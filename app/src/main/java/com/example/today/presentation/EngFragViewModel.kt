package com.example.today.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.today.data.db.firebasedb.FirebaseService
import com.example.today.data.db.model.Eng
import com.example.today.data.db.model.Movie
import com.example.today.data.db.model.Music
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EngFragViewModel @Inject constructor() : ViewModel() {
    private val _eng = MutableLiveData<Eng>()
    val eng: LiveData<Eng> = _eng

    init {
        viewModelScope.launch {
            _eng.value = FirebaseService.getEngData(1)
        }
    }

}