package com.yoochangwonspro.libraryreviewproject.model

import com.google.gson.annotations.SerializedName

data class SearchBookDto(
    @SerializedName("title") val title: String,
    @SerializedName("item") val item: List<Book>
)