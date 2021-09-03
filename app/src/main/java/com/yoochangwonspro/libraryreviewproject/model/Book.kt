package com.yoochangwonspro.libraryreviewproject.model

import com.google.gson.annotations.SerializedName
import java.io.FileDescriptor

data class Book(
    @SerializedName("itemId") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("descriptor") val descriptor: String,
    @SerializedName("coverSmallUrl") val coverSmallUrl: String
)