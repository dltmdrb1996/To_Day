package com.example.today.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.today.domain.model.Movie
import com.example.today.domain.usecase.GetMovieDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieFragViewModel @Inject constructor(private val getMovieDataUseCase: GetMovieDataUseCase) : ViewModel() {
    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    init {
        viewModelScope.launch {
            _movie.value = getMovieDataUseCase(1)!!
        }
    }

}