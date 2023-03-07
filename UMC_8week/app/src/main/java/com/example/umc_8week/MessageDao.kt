package com.example.umc_8week

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MessageDao {
    @Insert
    fun insert(message: Message)

    @Delete
    fun delete(message: Message)

    @Query("SELECT * FROM Message")
    fun selectAll():List<Message>

    @Query("SELECT * FROM Message WHERE messageID = :MessageID")
    fun selectByMessageID(MessageID: Int): Message

    @Query("SELECT * FROM Message WHERE Message = :Message")
    fun selectByMessage(Message:String):List<Message>

    @Query("UPDATE Message SET Message = :Message WHERE MessageID = :MessageID")
    fun updateMessageByID(MessageID: Int, Message: String)

}