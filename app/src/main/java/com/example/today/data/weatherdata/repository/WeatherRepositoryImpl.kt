package com.example.today.data.weatherdata.repository

import com.example.today.data.mapper.LocationMapper
import com.example.today.data.mapper.LocationWeatherMapper
import com.example.today.data.weatherdata.datasource.WeatherDataSource
import com.example.today.data.weatherdata.network.WeatherServiceApi
import com.example.today.di.IOScheduler
import com.example.today.domain.model.Location
import com.example.today.domain.model.LocationWeather
import com.example.today.domain.repository.WeatherRepository
import com.example.today.util.Either
import com.example.today.util.NetworkHandler
import com.example.today.util.error.Failure
import com.example.today.util.error.HttpRequestFailException
import com.example.today.util.error.NullResponseBodyException
import io.reactivex.Observable
import io.reactivex.Scheduler
import retrofit2.Call
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