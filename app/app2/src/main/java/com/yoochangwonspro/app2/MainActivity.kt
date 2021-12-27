package com.yoochangwonspro.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoochangwonspro.app2.adpater.BookAdapter
import com.yoochangwonspro.app2.databinding.ActivityMainBinding
import com.yoochangwonspro.app2.dto.BestSellerDto
import com.yoochangwonspro.app2.model.Book
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

    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launch(coroutineContext) {
            loadBestSeller()
        }

        initAdapter()
        initViews()
    }

    private fun initAdapter() {
        adapter = BookAdapter()
    }

    private fun initViews() {
        binding.bookRecyclerView.adapter = adapter
        binding.bookRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.searchButton.setOnClickListener {
            launch(coroutineContext) {
                loadSearchBook()
            }
        }
    }

    private suspend fun loadBestSeller() = withContext(Dispatchers.IO) {
        val response = RetrofitUtil.bookService.getBestSeller(MyKey.MY_KEY)

        if (response.isSuccessful) {
            val body = response.body()

            withContext(Dispatchers.Main) {
                body?.let {
                    adapter.setData(it.books)
                }
            }
        }
    }

    private fun loadSearchBook() = with(binding) {
        val bookName = searchKeywordEditText.text.toString()

        launch(coroutineContext) {
            withContext(Dispatchers.IO) {
                val response = RetrofitUtil.bookService.getSearchBook(MyKey.MY_KEY, bookName)

                if (response.isSuccessful) {
                    val body = response.body()

                    withContext(Dispatchers.Main) {
                        body?.let {
                            adapter.setData(it.books)
                        }
                    }
                }
            }
        }
    }
}