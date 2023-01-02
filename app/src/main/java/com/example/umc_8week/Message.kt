package com.example.umc_8week

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @ColumnInfo(name = "message") val message:String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="messageID") val star:Int=0
)
