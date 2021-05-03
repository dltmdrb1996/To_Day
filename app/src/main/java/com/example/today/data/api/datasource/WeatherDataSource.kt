package com.example.today.data.api.datasource

import com.example.today.data.api.model.LocationDTO
import com.example.today.data.api.model.LocationWeatherDTO
import io.reactivex.Observable

interface WeatherDataSource {
    fun getLocations(search: String): Observable<List<LocationDTO>>
    fun getLocationWeather(id: Long): Observable<LocationWeatherDTO>
}