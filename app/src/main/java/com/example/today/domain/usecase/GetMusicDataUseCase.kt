package com.example.today.domain.usecase

import com.example.today.domain.model.Music
import com.example.today.domain.repository.FireBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMusicDataUseCase @Inject constructor(
    private val fireBaseRepository: FireBaseRepository,
) {
    suspend operator fun invoke(): Music? =
      withContext(Dispatchers.IO) {
          fireBaseRepository.getMusicData(1)
      }
}