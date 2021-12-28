package com.yoochangwonspro.app2.database

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private const val DB_NAME = "history_app.db"

    fun historyProviderDB(applicationContext: Context) = Room.databaseBuilder(
        applicationContext,
        SearchHistoryDatabase::class.java,
        DB_NAME
    ).build()
}