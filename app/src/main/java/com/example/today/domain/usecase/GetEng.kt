package com.example.today.domain.usecase

import com.example.today.domain.model.Eng
import com.example.today.domain.repository.FireBaseRepository
import javax.inject.Inject

class GetEng @Inject constructor(private val fireBaseRepository: FireBaseRepository) :
    UseCase<Eng?, GetEng.Params>() {

    override suspend fun run(params: Params) = fireBaseRepository.getEngData(params.day)

    data class Params(val day: Int)
}