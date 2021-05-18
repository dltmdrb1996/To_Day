package com.example.today.data.weatherdata.datasource

import com.example.today.data.weatherdata.model.LocationDTO
import com.example.today.data.weatherdata.model.LocationWeatherDTO
import io.reactivex.Observable

interface WeatherDataSource {
    fun getLocations(search: String): Observable<List<LocationDTO>>
    fun getLocationWeather(id: Long): Observable<LocationWeatherDTO>
}