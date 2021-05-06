package com.example.today.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.today.data.db.model.Movie

@Dao
interface DbDao {

    @Query("SELECT * FROM Movie")
    fun observeTasks(): LiveData<List<Movie>>


    @Query("SELECT * FROM Movie WHERE num = :number")
    fun observeTaskById(number: Int): LiveData<Movie>


    @Query("SELECT * FROM Movie")
    fun getTasks(): List<Movie>


    @Query("SELECT * FROM Movie WHERE num = :number")
    fun getTaskById(number: Int) : Movie?

}
