package com.example.today.presentation

import androidx.lifecycle.LiveData
import com.example.today.data.db.datasource.LocalDataSource
import com.example.today.data.db.model.Movie

class MovieFragViewModel(localDataSource: LocalDataSource) {


    private val _movie : LiveData<Movie> = localDataSource.observerMovie(1)
    val movie : LiveData<Movie> = _movie


}