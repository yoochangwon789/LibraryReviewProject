package com.yoochangwonspro.libraryreviewproject

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yoochangwonspro.libraryreviewproject.dao.HistoryDao
import com.yoochangwonspro.libraryreviewproject.model.History

@Database(entities = [History::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}