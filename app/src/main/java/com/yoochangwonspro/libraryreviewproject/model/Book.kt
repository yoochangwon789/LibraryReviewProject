package com.yoochangwonspro.libraryreviewproject.model

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("itemId") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("descriptor") val description: String,
    @SerializedName("coverSmallUrl") val coverSmallUrl: String
)