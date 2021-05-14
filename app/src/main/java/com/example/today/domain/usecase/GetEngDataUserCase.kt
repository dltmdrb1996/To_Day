package com.example.today.domain.usecase

import com.example.today.domain.model.Eng
import com.example.today.domain.repository.FireBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetEngDataUseCase @Inject constructor(
    private val fireBaseRepository: FireBaseRepository,
) {
    suspend operator fun invoke(): Eng? =
        coroutineScope {
            fireBaseRepository.getEngData(1)
        }

}