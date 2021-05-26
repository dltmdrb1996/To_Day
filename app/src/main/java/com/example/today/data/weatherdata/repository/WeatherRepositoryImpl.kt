package com.example.today.data.weatherdata.repository

import com.example.today.data.db.model.MovieDTO.Companion.toMovie
import com.example.today.data.weatherdata.datasource.WeatherDataSource
import com.example.today.data.mapper.LocationMapper
import com.example.today.data.mapper.LocationWeatherMapper
import com.example.today.domain.model.Location
import com.example.today.domain.model.LocationWeather
import com.example.today.domain.repository.WeatherRepository
import com.example.today.util.Either
import com.example.today.util.NetworkHandler
import com.example.today.util.error.Failure
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource,
    private val locationWeatherMapper: LocationWeatherMapper,
    private val locationMapper: LocationMapper,
    private val networkHandler: NetworkHandler
) : WeatherRepository {

    override fun getLocations(search: String): Either<Failure, Observable<List<Location>>> {

        return when (networkHandler.isNetworkAvailable()) {
            true -> Either.Right(weatherDataSource.getLocations(search).map {
                it.map { locationMapper.transform(it) }
            })
            false -> Either.Left(Failure.ServerError)
        }
    }

    override fun getLocationWeather(id: Long): Observable<LocationWeather> {
        return weatherDataSource.getLocationWeather(id).map {
            locationWeatherMapper.transform(it)
        }
    }


}