package com.example.today.domain.repository

import androidx.lifecycle.LiveData
import com.example.today.domain.model.Save

interface SaveRepository {
    fun getAll(): LiveData<List<Save>>

    suspend fun insert(save: Save)

    suspend fun delete(save: Save)

    suspend fun nukeTable()
}