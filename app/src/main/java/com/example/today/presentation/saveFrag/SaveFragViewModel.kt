package com.example.today.presentation.saveFrag

import androidx.lifecycle.*
import com.example.today.domain.model.Save
import com.example.today.domain.usecase.RoomDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveFragViewModel @Inject constructor(
    private val roomDataUseCase: RoomDataUseCase
) : ViewModel() {


    private val _items: LiveData<List<Save>> = getAll()
    val items: LiveData<List<Save>> = _items

    val title: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    private fun getAll(): LiveData<List<Save>> {
        return roomDataUseCase.getAll()
    }


    fun nukeTable() {
        viewModelScope.launch {
            roomDataUseCase.nukeTable()
        }
    }

    fun delete(todo: Save) {
        viewModelScope.launch {
            roomDataUseCase.delete(todo)
        }
    }

}

