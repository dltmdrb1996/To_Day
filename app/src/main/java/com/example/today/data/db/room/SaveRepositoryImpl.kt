package com.example.today.data.db.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.today.data.mapper.SaveMapper
import com.example.today.domain.model.Save
import com.example.today.domain.repository.SaveRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveRepositoryImpl internal constructor(
    private val saveDao: SaveDao,
    private val ioDispatcher: CoroutineDispatcher,
    private val saveMapper: SaveMapper
) : SaveRepository {
    override fun getAll(): LiveData<List<Save>> {
        return saveDao.getAll().map { list ->
            list.map {
                saveMapper.transform(it)
            }
        }
    }
    override suspend fun insert(save: Save) {
        withContext(ioDispatcher) {
            saveDao.insert(saveMapper.reTransform(save))
        }
    }

    override suspend fun delete(save: Save) {
        withContext(ioDispatcher) {
            saveDao.deleteFromId(save.id)
        }
    }

    override suspend fun nukeTable() {
        withContext(ioDispatcher) {
            saveDao.nukeTable()
        }
    }


}