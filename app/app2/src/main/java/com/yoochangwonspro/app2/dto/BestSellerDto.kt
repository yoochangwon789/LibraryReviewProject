package com.yoochangwonspro.app2.dto

import com.google.gson.annotations.SerializedName
import com.yoochangwonspro.app2.model.Book

data class BestSellerDto(
    @SerializedName("title") val title: String,
    @SerializedName("item") val books: List<Book>
)