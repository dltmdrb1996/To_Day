package com.example.today.domain.repository

import com.example.today.data.db.model.EngDTO
import com.example.today.data.db.model.MovieDTO
import com.example.today.data.db.model.MusicDTO

interface FireBaseRepository {
    suspend fun getMovieData(day: Int): MovieDTO?
    suspend fun getEngData(day: Int): EngDTO?
    suspend fun getMusicData(day: Int): MusicDTO?
}