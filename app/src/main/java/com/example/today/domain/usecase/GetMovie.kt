package com.example.today.domain.usecase

import com.example.today.domain.model.Movie
import com.example.today.domain.repository.FireBaseRepository
import javax.inject.Inject

class GetMovie @Inject constructor(private val fireBaseRepository: FireBaseRepository) :
    UseCase<Movie?, GetMovie.Params>() {

    override suspend fun run(params: Params) = fireBaseRepository.getMovieData(params.day)

    data class Params(val day: Int)
}