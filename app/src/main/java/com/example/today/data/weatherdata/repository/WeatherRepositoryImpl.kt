package com.example.today.data.weatherdata.repository

import com.example.today.data.mapper.LocationMapper
import com.example.today.data.mapper.LocationWeatherMapper
import com.example.today.data.weatherdata.datasource.WeatherDataSource
import com.example.today.domain.model.Location
import com.example.today.domain.model.LocationWeather
import com.example.today.domain.repository.WeatherRepository
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource,
    private val locationWeatherMapper: LocationWeatherMapper,
    private val locationMapper: LocationMapper
) : WeatherRepository {

    override fun getLocations(search: String): Observable<List<Location>> {
        return weatherDataSource.getLocations(search).map {
            it.map { locationMapper.transform(it) }
        }
    }

    override fun getLocationWeather(id: Long): Observable<LocationWeather> {
        return weatherDataSource.getLocationWeather(id).map {
            locationWeatherMapper.transform(it)
        }
    }
}