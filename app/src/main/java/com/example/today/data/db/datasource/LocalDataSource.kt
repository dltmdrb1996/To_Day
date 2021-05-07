package com.example.today.data.db.datasource

import androidx.lifecycle.LiveData
import com.example.today.data.db.DbDao
import com.example.today.data.db.Result
import com.example.today.data.db.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(
    private val dbDao: DbDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    lateinit var result : List<Movie>

    suspend fun getAllMovie(): List<Movie> {
        withContext(ioDispatcher) {
            val returnedrepo = dbDao.getTasks()
            result = returnedrepo
        }
        return result
    }


    fun observerMovie(num: Int) : LiveData<Movie>{
        return dbDao.observeTaskById(num)
    }

    fun getMovie() : LiveData<List<Movie>>{
        return dbDao.observeTasks()
    }

}