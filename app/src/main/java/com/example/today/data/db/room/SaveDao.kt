package com.example.today.data.db.room
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SaveDao {
    @Query("SELECT * FROM SaveDTO")
    fun getAll(): LiveData<List<SaveDTO>>

    @Insert
    fun insert(saveDTO: SaveDTO)

    @Delete
    fun delete(saveDTO: SaveDTO)

    @Query("DELETE FROM SaveDTO WHERE id = :id")
    fun deleteFromId(id : Int)

    @Query("DELETE FROM SaveDTO")
    fun nukeTable()
}