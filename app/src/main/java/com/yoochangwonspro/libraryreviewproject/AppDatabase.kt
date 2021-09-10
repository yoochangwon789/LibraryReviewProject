package com.yoochangwonspro.libraryreviewproject

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yoochangwonspro.libraryreviewproject.dao.HistoryDao
import com.yoochangwonspro.libraryreviewproject.dao.ReviewDao
import com.yoochangwonspro.libraryreviewproject.model.History
import com.yoochangwonspro.libraryreviewproject.model.Review

@Database(entities = [History::class, Review::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao
    abstract fun reviewDao(): ReviewDao
}