package com.example.today.domain.repository

import com.example.today.domain.model.Eng
import com.example.today.domain.model.Movie
import com.example.today.domain.model.Music
import com.example.today.util.Either
import com.example.today.util.error.Failure

interface FireBaseRepository {
    suspend fun getMovieData(day: Int): Either<Failure, Movie?>
    suspend fun getEngData(day: Int): Either<Failure, Eng?>
    suspend fun getMusicData(day: Int): Either<Failure, Music?>
}