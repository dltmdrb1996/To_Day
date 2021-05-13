package com.example.today.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.today.data.db.firebasedb.FirebaseService
import com.example.today.data.db.model.MovieDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieFragViewModel @Inject constructor() : ViewModel() {
    private val _movie = MutableLiveData<MovieDTO>()
    val movie: LiveData<MovieDTO> = _movie

    init {
        viewModelScope.launch {
            _movie.value = FirebaseService.getMovieData(1)
        }
    }

}