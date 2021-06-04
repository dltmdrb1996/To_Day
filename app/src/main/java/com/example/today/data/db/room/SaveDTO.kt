package com.example.today.data.db.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SaveDTO(@ColumnInfo(name = "title") var title: String = ""){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    val setId : String
        get() = id.toString()
}
