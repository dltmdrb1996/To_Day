package com.example.today.domain.usecase

import com.example.today.domain.mapper.MovieMapper
import com.example.today.domain.mapper.MusicMapper
import com.example.today.domain.model.Movie
import com.example.today.domain.model.Music
import com.example.today.domain.repository.FireBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMusicDataUseCase @Inject constructor(
    private val fireBaseRepository: FireBaseRepository,
    private val musicMapper: MusicMapper
) {
    suspend operator fun invoke(search: Int): Music? =
      withContext(Dispatchers.IO) {
          fireBaseRepository.getMusicData(1)?.let { musicMapper.transform(it) }
      }
}