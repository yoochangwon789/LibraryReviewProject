package com.yoochangwonspro.app2.utillity

import com.yoochangwonspro.app2.response.Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtil {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Url.INTERPARK_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}