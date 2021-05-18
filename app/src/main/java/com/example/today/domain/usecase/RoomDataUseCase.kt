package com.example.today.domain.usecase

import androidx.lifecycle.LiveData
import com.example.today.domain.model.Save
import com.example.today.domain.repository.SaveRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RoomDataUseCase @Inject constructor(
    private val saveRepository: SaveRepository,
    private val ioDispatcher: CoroutineDispatcher

    ) {
    fun getAll() : LiveData<List<Save>>{
        return saveRepository.getAll()
    }
    suspend fun insert(title : String){
        withContext(ioDispatcher) {
            saveRepository.insert(Save(title,0))
        }
    }
    suspend fun delete(save: Save) {
        withContext(ioDispatcher) {
            saveRepository.delete(save)
        }
    }

    suspend fun nukeTable() {
        withContext(ioDispatcher) {
            saveRepository.nukeTable()
        }
    }
}