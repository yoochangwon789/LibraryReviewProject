package com.yoochangwonspro.app2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yoochangwonspro.app2.dao.SearchHistoryDao
import com.yoochangwonspro.app2.model.SearchHistory

@Database(entities = [SearchHistory::class], version = 1)
abstract class SearchHistoryDatabase : RoomDatabase() {

    abstract fun searchHistoryDao(): SearchHistoryDao
}