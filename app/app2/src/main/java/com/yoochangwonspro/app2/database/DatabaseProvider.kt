package com.yoochangwonspro.app2.database

import android.content.Context
import androidx.room.Room
import com.yoochangwonspro.app2.model.History

object DatabaseProvider {

    private const val DB_NAME = "history_app.db"

    fun historyProviderDB(applicationContext: Context) = Room.databaseBuilder(
        applicationContext,
        HistoryDatabase::class.java,
        DB_NAME
    ).build()
}