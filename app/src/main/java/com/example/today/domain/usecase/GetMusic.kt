package com.example.today.domain.usecase

import com.example.today.domain.model.Music
import com.example.today.domain.repository.FireBaseRepository
import javax.inject.Inject

class GetMusic @Inject constructor(private val fireBaseRepository: FireBaseRepository) :
    UseCase<Music?, GetMusic.Params>() {

    override suspend fun run(params: Params) = fireBaseRepository.getMusicData(params.day)

    data class Params(val day: Int)
}