package com.example.today.domain.usecase

import com.example.today.domain.mapper.EngMapper
import com.example.today.domain.model.Eng
import com.example.today.domain.repository.FireBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetEngDataUseCase @Inject constructor(
    private val fireBaseRepository: FireBaseRepository,
    private val engMapper: EngMapper
) {
    suspend operator fun invoke(search: Int): Eng? =
        withContext(Dispatchers.IO) {
            fireBaseRepository.getEngData(1)?.let { engMapper.transform(it) }
        }
}