package com.yoochangwonspro.app2.utillity

import com.yoochangwonspro.app2.dto.BestSellerDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET("/api/bestSeller.api?output=json&categoryId=100")
    suspend fun getBestSeller(
        @Query("key") key: String
    ): Response<BestSellerDto>

    @GET("/api/search.api?output=json")
    suspend fun getSearchBook(
        @Query("key") key: String,
        @Query("query") bookName: String
    ): Response<BestSellerDto>
}