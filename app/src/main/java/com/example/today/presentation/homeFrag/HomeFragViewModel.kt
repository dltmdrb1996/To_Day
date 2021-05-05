package com.example.today.presentation.homeFrag

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.today.R
import com.example.today.di.MainScheduler
import com.example.today.domain.model.LocationWeather
import com.example.today.domain.usecase.SearchLocationWeathersUseCase
import com.example.today.util.error.HttpRequestFailException
import com.example.today.util.error.NullResponseBodyException
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class HomeFragViewModel @Inject constructor(
    private val searchLocationWeathersUseCase: SearchLocationWeathersUseCase,
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

    private val _toastTextId = MutableLiveData<Int>()
    val toastTextId: LiveData<Int>
        get() = _toastTextId


    fun search(search: String) {
        if (_dataLoading.value == true || search == _search.value) {
            return
        }
        _search.value = search
        getLocationWeathers()
    }

    fun refresh() {
        if (_dataLoading.value == true) {
            return
        }
        getLocationWeathers()
    }

    private fun getLocationWeathers() {
        _search.value?.let { search ->
            _dataLoading.value = true
            disposable.add(
                searchLocationWeathersUseCase(search).observeOn(scheduler).doFinally {
                    _dataLoading.value = false
                }.subscribe({
                    _locationWeathers.value = it
                }, { error ->
                    Log.e(TAG, "Failure to get Weather", error)
                    processError(error)
                })
            )
        }
    }

    private fun processError(error: Throwable) {
        var stringId = R.string.default_error_message
        when (error) {
            is HttpRequestFailException ->
                stringId = R.string.http_requst_fail_error_message
            is NullResponseBodyException ->
                stringId = R.string.null_response_body_error_message
        }
        _toastTextId.value = stringId
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}