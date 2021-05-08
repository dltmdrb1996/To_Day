package com.example.today.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.today.data.db.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieFragViewModel @Inject constructor() : ViewModel() {

    val test = 5
}