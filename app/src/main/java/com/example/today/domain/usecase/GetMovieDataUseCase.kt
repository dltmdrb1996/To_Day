package com.example.today.domain.usecase

import com.example.today.domain.model.Movie
import com.example.today.domain.repository.FireBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMovieDataUseCase @Inject constructor(
    private val fireBaseRepository: FireBaseRepository,
) {
    suspend operator fun invoke(): Movie? =
        withContext(Dispatchers.IO) {
            fireBaseRepository.getMovieData(1)
        }
}