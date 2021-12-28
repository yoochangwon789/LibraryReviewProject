package com.yoochangwonspro.app2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yoochangwonspro.app2.dao.HistoryDao
import com.yoochangwonspro.app2.model.History

@Database(entities = [History::class], version = 1)
abstract class HistoryDatabase : RoomDatabase() {

    abstract fun historyDao(): HistoryDao
}