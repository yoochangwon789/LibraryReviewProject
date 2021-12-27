package com.yoochangwonspro.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yoochangwonspro.app2.databinding.ActivityMainBinding
import com.yoochangwonspro.app2.dto.BestSellerDto
import com.yoochangwonspro.app2.response.MyKey
import com.yoochangwonspro.app2.utillity.RetrofitUtil
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: ActivityMainBinding

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launch(coroutineContext) {
            loadBestSeller()
        }
    }

    private suspend fun loadBestSeller() = withContext(Dispatchers.IO) {
        RetrofitUtil.bookService.getBestSeller(MyKey.MY_KEY).enqueue(
            object : Callback<BestSellerDto> {
                override fun onResponse(
                    call: Call<BestSellerDto>,
                    response: Response<BestSellerDto>,
                ) {
                    val body = response.body()

                    if (response.isSuccessful) {
                        body?.let {
                            Log.e("RESPONSE", it.title)

                            it.books.forEach { book ->
                                Log.e("books", "$book")
                            }
                        }
                    } else {
                        Log.e("Failure2", "Failure2")
                    }
                }

                override fun onFailure(call: Call<BestSellerDto>, t: Throwable) {
                    Log.e("Failure", "Failure")
                }

            }
        )

    }

}