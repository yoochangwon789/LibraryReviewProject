package com.yoochangwonspro.app2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchHistory(
    @PrimaryKey val uid: Int?,
    @ColumnInfo(name = "history_name") val historyName: String?
)
