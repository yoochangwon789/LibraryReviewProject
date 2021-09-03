package com.yoochangwonspro.libraryreviewproject.api

import com.yoochangwonspro.libraryreviewproject.model.BestSellerDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET("/api/search.api?output=json")
    fun getBooksByName(
        @Query("key") apiKey: String,
        @Query("query") keyword: String
    ) : Call<>

    @GET("/api/bestSeller.api?output=json&categoryId=100")
    fun getBestSellerBooks(
        @Query("key") apiKey: String
    ) : Call<BestSellerDto>
}