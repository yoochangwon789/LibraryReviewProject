package com.yoochangwonspro.libraryreviewproject.dao

import androidx.room.Dao
import androidx.room.Query
import com.yoochangwonspro.libraryreviewproject.model.History

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history")
    fun getAll(): List<History>
}