package com.yoochangwonspro.libraryreviewproject.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ReviewDao {

    @Query("SELECT * FROM review WHERE id == :id")
    fun getOnReview(id: Int): Review
}