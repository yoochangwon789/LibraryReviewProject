package com.yoochangwonspro.libraryreviewproject.model

import com.google.gson.annotations.SerializedName

data class BestSellerDto(
    @SerializedName("title") val title: String,
    @SerializedName("item") val books: List<Book>,

    // BestSellerDto 전체 API response 를 받아오게 되면 title, item 이 매칭이 되고
    // item 을 보니 타입을 List 형식의 Book 의 데이터 클래스인것을 확인할 수 있다
)