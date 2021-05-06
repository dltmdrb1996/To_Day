package com.example.today.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey @ColumnInfo(name = "num") var num: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "time") var time: Int,
    @ColumnInfo(name = "director") var director: String,
    @ColumnInfo(name = "actor") var actor: String,
    @ColumnInfo(name = "win") var win: String,
    @ColumnInfo(name = "script") var script: String
) {


}
