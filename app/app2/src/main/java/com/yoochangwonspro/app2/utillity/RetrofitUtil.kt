package com.yoochangwonspro.app2.utillity

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.yoochangwonspro.app2.response.Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtil {

    val bookService: BookService by lazy {
        getRetrofit().create(BookService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Url.INTERPARK_URL)
            .addConverterFactory(GsonConverterFactory.create(
                GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setLenient()
                    .create()
            ))
            .build()
    }
}