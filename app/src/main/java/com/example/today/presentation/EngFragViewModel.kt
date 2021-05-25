package com.example.today.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.today.domain.model.Eng
import com.example.today.domain.usecase.GetEng
import com.example.today.domain.usecase.RoomDataUseCase
import com.example.today.util.error.Failure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EngFragViewModel @Inject constructor(
    private val getEng: GetEng,
    private val roomDataUseCase: RoomDataUseCase
) : ViewModel() {

    private val _eng = MutableLiveData<Eng>()
    val eng: LiveData<Eng> = _eng

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    fun insert(title: String) {
        viewModelScope.launch {
            roomDataUseCase.insert(title)
        }
    }
    fun loadEngDetails(day: Int) =
        getEng(GetEng.Params(day)) { it.fold(::handleFailure, ::handleEngDetails) }

    private fun handleEngDetails(en: Eng?) {
        _eng.value = en?.apply { Eng(img, person, eng, kor) }
    }

    private fun handleFailure(failure: Failure) { _failure.value = failure }

}