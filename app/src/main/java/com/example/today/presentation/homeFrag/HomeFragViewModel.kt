package com.example.today.presentation.homeFrag

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.today.R
import com.example.today.di.MainScheduler
import com.example.today.domain.model.LocationWeather
import com.example.today.domain.usecase.GetWeather
import com.example.today.util.error.Failure
import com.example.today.util.error.HttpRequestFailException
import com.example.today.util.error.NullResponseBodyException
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragViewModel @Inject constructor(
//    private val searchLocationWeathersUseCase: SearchLocationWeathersUseCase,
    private val getWeather: GetWeather,
    @MainScheduler private val scheduler: Scheduler,
    private val disposable: CompositeDisposable
) : ViewModel() {

    companion object {
        private val TAG = HomeFragViewModel::class.java.simpleName
    }

    private val _search = MutableLiveData<String>()

    private val _locationWeathers = MutableLiveData<List<LocationWeather>>(emptyList())
    val locationWeathers: LiveData<List<LocationWeather>>
        get() = _locationWeathers

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    fun search(search: String) {
        if (_dataLoading.value == true || search == _search.value) {
            return
        }
        _search.value = search
        _search?.value?.let {loadMovieDetails(it) }
    }

    fun refresh() {
        if (_dataLoading.value == true) {
            return
        }
        _search?.value?.let {loadMovieDetails(it) }
    }

    fun loadMovieDetails(search: String) =
        viewModelScope.launch {
            getWeather(GetWeather.Params(search)) {
                it.fold(::handleFailure, ::getLocationWeathers)
            }
        }

    private fun getLocationWeathers(get : Single<List<LocationWeather>>) {
        _dataLoading.value = true
        disposable.add(
            get.observeOn(scheduler).doFinally {
                _dataLoading.value = false
            }.subscribe({
                _locationWeathers.value = it
            }, { error ->
                Log.e(TAG, "Failure to get Weather", error)
            })
        )
    }

    private fun handleFailure(failure: Failure) { _failure.value = failure }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }


}