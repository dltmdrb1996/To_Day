package com.example.today.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.today.domain.model.Movie
import com.example.today.domain.usecase.GetMovie
import com.example.today.domain.usecase.RoomDataUseCase
import com.example.today.util.error.Failure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieFragViewModel @Inject constructor(
    private val roomDataUseCase: RoomDataUseCase,
    private val getMovie: GetMovie
) : ViewModel() {
    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    fun insert(title : String) {
            viewModelScope.launch {
                roomDataUseCase.insert(title)
            }
    }

    fun loadMovieDetails(day: Int) =
        viewModelScope.launch {
            getMovie(GetMovie.Params(day)) {
                it.fold(::handleFailure, ::handleMovieDetails)
            }
        }

    private fun handleMovieDetails(movie: Movie?) {
        _movie.value = movie?.apply { Movie(title, director, img, actor, script, story, time) }
    }

    private fun handleFailure(failure: Failure) { _failure.value = failure }

}