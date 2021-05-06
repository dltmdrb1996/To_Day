package com.example.today.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Music(
    @PrimaryKey @ColumnInfo(name = "num") var num: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "singer") var singer: String,
    @ColumnInfo(name = "songwriter") var songwriter: String,
    @ColumnInfo(name = "words") var words: String,
    @ColumnInfo(name = "youtube") var youtube: String
) {

}
