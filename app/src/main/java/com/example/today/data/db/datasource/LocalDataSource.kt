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

    fun observerMovie(num: Int) : LiveData<Movie>{
        return dbDao.observeTaskById(num)
    }

//    suspend fun getMovie(num : Int) : Result<Movie> = withContext(ioDispatcher){
//        try {
//            val movie = dbDao.getTaskById(num)
//            if (movie != null) {
//                return@withContext Result.Success<Movie>
//            } else {
//                return@withContext Error(Exception("Task not found!"))
//            }
//        } catch (e: Exception) {
//            return@withContext Error(e)
//        }
//    }

}