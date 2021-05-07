package com.example.today.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.today.data.db.model.Movie

@Dao
interface DbDao {

    @Query("SELECT * FROM movieTBL")
    fun observeTasks(): LiveData<List<Movie>>


    @Query("SELECT * FROM movieTBL WHERE num = :number")
    fun observeTaskById(number: Int): LiveData<Movie>


    @Query("SELECT * FROM movieTBL")
    fun getTasks(): List<Movie>


    @Query("SELECT * FROM movieTBL WHERE num = :number")
    fun getTaskById(number: Int) : Movie

}
