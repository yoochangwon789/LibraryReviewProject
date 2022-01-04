package com.yoochangwonspro.app2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yoochangwonspro.app2.model.SearchHistory

@Dao
interface SearchHistoryDao {

    @Query("SELECT * FROM SearchHistory")
    suspend fun getAll(): List<SearchHistory>

    @Insert
    suspend fun insertHistory(searchHistory: SearchHistory)

    @Query( "DELETE FROM SearchHistory WHERE history_name == :historyName")
    suspend fun deleteHistory(historyName: String)
}