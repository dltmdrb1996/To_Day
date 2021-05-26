/**
 * Copyright (C) 2020 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.today.domain.usecase

import com.example.today.domain.model.LocationWeather
import com.example.today.domain.repository.WeatherRepository
import com.example.today.util.Either
import com.example.today.util.error.Failure
import com.example.today.util.flatMap
import com.example.today.util.map
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetWeather
@Inject constructor(private val weatherRepository: WeatherRepository) :
    UseCase<Single<List<LocationWeather>>, GetWeather.Params>() {

    override suspend fun run(params: Params): Either<Failure, Single<List<LocationWeather>>> =
        weatherRepository.getLocations(params.search).map {
            it.flatMapIterable { it }.concatMap {
                weatherRepository.getLocationWeather(it.id)
            }.flatMap {
                Observable.just(it)
            }.toList()
        }


    data class Params(val search: String)

}


