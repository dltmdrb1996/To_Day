package com.example.today.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.today.data.db.DbDao
import com.example.today.data.db.datasource.LocalDataSource
import com.example.today.data.db.model.Movie
import com.example.today.data.db.myDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieFragViewModel @Inject constructor(private val localDataSource: LocalDataSource) :
    ViewModel() {

//    val movie: LiveData<Movie> =  localDataSource.observerMovie(1)

    lateinit var test : List<Movie>

    private val _items: LiveData<List<Movie>> = getAll()
    val items: LiveData<List<Movie>> = _items



    fun getAll(): LiveData<List<Movie>> {
        return localDataSource.getMovie()
    }

}