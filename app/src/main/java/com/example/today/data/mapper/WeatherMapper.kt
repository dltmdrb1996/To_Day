package com.example.today.data.mapper

import com.example.today.data.weatherdata.model.WeatherDTO
import com.example.today.domain.model.Weather
import com.example.today.util.IconUrlGenerator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherMapper @Inject constructor(
    private val iconUrlGenerator: IconUrlGenerator
) {
    fun transform(weather: WeatherDTO): Weather =
        with(weather) {
            return Weather(
                id = id,
                humidity = humidity,
                icon = iconUrlGenerator.getPngIconUrl(icon),
                state = state,
                temp = temp
            )
        }

}