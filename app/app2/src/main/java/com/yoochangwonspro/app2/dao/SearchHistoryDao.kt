package com.yoochangwonspro.app2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SearchHistoryDao {

    @Query("SELECT * FROM history")
    suspend fun getAll(): List<History>

    @Insert
    suspend fun insertHistory(history: History)

    @Query("SELECT * FROM history WHERE history_name == :historyName")
    suspend fun deleteHistory(historyName: String)
}