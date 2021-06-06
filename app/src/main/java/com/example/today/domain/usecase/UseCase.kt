package com.example.today.domain.usecase

import com.example.today.util.Either
import com.example.today.util.error.Failure
import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        CoroutineScope(Dispatchers.Main).launch {
            val job = async(Dispatchers.IO) { run(params) }
            onResult(job.await()) }
    }

}
