package com.example.today.data.mapper
import com.example.today.data.weatherdata.model.LocationWeatherDTO
import com.example.today.domain.model.LocationWeather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationWeatherMapper @Inject constructor(
    private val weatherMapper: WeatherMapper
) {
    fun transform(locationWeatherDTO: LocationWeatherDTO): LocationWeather =
        with(locationWeatherDTO) {
            LocationWeather(
                locationTitle = locationTitle,
                locationId = locationId,
                weathers = weatherList.map { weatherMapper.transform(it) }
            )
        }
}