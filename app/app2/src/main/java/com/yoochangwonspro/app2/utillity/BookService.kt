package com.yoochangwonspro.app2.utillity

import retrofit2.http.GET

interface BookService {

    @GET("bestSeller.api?output=json")
    fun getBestSeller()
}