package com.yoochangwonspro.libraryreviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yoochangwonspro.libraryreviewproject.api.BookService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val bookService = retrofit.create(BookService::class.java)


    }
}