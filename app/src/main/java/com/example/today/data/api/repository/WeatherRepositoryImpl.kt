package com.example.today.data.api.repository

import android.os.Parcel
import android.os.Parcelable
import com.example.today.data.api.datasource.WeatherDataSource
import com.example.today.domain.mapper.LocationMapper
import com.example.today.domain.mapper.LocationWeatherMapper
import com.example.today.domain.model.Location
import com.example.today.domain.model.LocationWeather
import com.example.today.domain.repository.WeatherRepository
import io.reactivex.Observable
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource,
    private val locationWeatherMapper: LocationWeatherMapper,
    private val locationMapper: LocationMapper
) : WeatherRepository, Parcelable {

    constructor(parcel: Parcel) : this(
        TODO("weatherDataSource"),
        TODO("locationWeatherMapper"),
        TODO("locationMapper")
    ) {
    }

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherRepositoryImpl> {
        override fun createFromParcel(parcel: Parcel): WeatherRepositoryImpl {
            return WeatherRepositoryImpl(parcel)
        }

        override fun newArray(size: Int): Array<WeatherRepositoryImpl?> {
            return arrayOfNulls(size)
        }
    }
}