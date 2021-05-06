package com.example.today.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.today.data.db.model.Eng
import com.example.today.data.db.model.Movie
import com.example.today.data.db.model.Music


@Database(entities = [Movie::class, Music::class, Eng::class], version = 1, exportSchema = false)
abstract class myDB : RoomDatabase() {
    abstract fun DbDao(): DbDao
}