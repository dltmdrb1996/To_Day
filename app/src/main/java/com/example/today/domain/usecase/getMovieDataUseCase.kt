package com.example.today.domain.usecase

import com.example.today.data.db.firebasedb.FirebaseService
import com.example.today.domain.mapper.EngMapper
import com.example.today.domain.model.Eng
import com.example.today.domain.model.LocationWeather
import io.reactivex.Observable
import io.reactivex.Single

class getMovieDataUseCase {
    val testMapper = EngMapper()
    suspend operator fun invoke(search : Int): Eng? {
        return FirebaseService.getEngData(1)?.let { testMapper.transform(it) }
    }
}