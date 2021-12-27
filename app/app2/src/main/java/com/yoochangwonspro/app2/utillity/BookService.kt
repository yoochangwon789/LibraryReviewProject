package com.yoochangwonspro.app2.utillity

import com.yoochangwonspro.app2.dto.BestSellerDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET("bestSeller.api?output=json/categoryId=100")
    fun getBestSeller(
        @Query("key") key: String
    ): Call<BestSellerDto>
}