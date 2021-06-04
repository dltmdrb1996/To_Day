package com.example.today.domain.repository

import com.example.today.domain.model.Location
import com.example.today.domain.model.LocationWeather
import com.example.today.util.Either
import com.example.today.util.error.Failure
import io.reactivex.Observable

interface WeatherRepository {
    fun getLocations(search: String): Observable<List<Location>>
    fun getLocationWeather(id: Long): Observable<LocationWeather>
}