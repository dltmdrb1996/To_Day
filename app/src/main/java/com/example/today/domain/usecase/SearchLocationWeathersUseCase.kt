package com.example.today.domain.usecase

import com.example.today.domain.model.LocationWeather
import com.example.today.domain.repository.WeatherRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class SearchLocationWeathersUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
) {
    operator fun invoke(search: String): Single<List<LocationWeather>> {
        return weatherRepository.getLocations(search).flatMapIterable { it }.concatMapEager { location ->
            weatherRepository.getLocationWeather(location.id)
        }.flatMap {
            Observable.just(it)
        }.toList()
    }
}