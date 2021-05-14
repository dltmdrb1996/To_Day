package com.example.today.domain.repository

import com.example.today.domain.model.Eng
import com.example.today.domain.model.Movie
import com.example.today.domain.model.Music

interface FireBaseRepository {
    suspend fun getMovieData(day: Int): Movie?
    suspend fun getEngData(day: Int): Eng?
    suspend fun getMusicData(day: Int): Music?
}