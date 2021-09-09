package com.yoochangwonspro.libraryreviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.yoochangwonspro.libraryreviewproject.adapter.BookAdapter
import com.yoochangwonspro.libraryreviewproject.api.BookService
import com.yoochangwonspro.libraryreviewproject.databinding.ActivityMainBinding
import com.yoochangwonspro.libraryreviewproject.model.BestSellerDto
import com.yoochangwonspro.libraryreviewproject.model.History
import com.yoochangwonspro.libraryreviewproject.model.SearchBookDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BookAdapter
    private lateinit var bookService: BookService
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBookRecyclerView()

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "BookSearchDB"
        ).build()

        // 레드로핏 초기화
        val retrofit = Retrofit.Builder()
            .baseUrl("https://book.interpark.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        bookService = retrofit.create(BookService::class.java)

        bookService.getBestSellerBooks(getString(R.string.interparkAPIKey))
            .enqueue(object : Callback<BestSellerDto> {
                override fun onResponse(
                    call: Call<BestSellerDto>,
                    response: Response<BestSellerDto>,
                ) {
                    if (response.isSuccessful.not()) {
                        Log.e(TAG, "NOT!! SUCCESS")
                        return
                    }

                    response.body()?.let {
                        Log.d(TAG, it.toString())

                        it.books.forEach { book ->
                            Log.d(TAG, book.toString())
                        }

                        adapter.submitList(it.books)
                    }
                }

                override fun onFailure(call: Call<BestSellerDto>, t: Throwable) {
                    // 실패 처리
                    Log.e(TAG, t.toString())
                }

            })

        // 키보드가 입력이 되었을 시에 이벤트를 받고 활용할 수 있는 함수
        binding.searchEditText.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == MotionEvent.ACTION_DOWN) {
                search(binding.searchEditText.text.toString())
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }

    private fun search(keyword: String) {
        bookService.getBooksByName(getString(R.string.interparkAPIKey), keyword)
            .enqueue(object : Callback<SearchBookDto> {
                override fun onResponse(
                    call: Call<SearchBookDto>,
                    response: Response<SearchBookDto>,
                ) {

                    saveSearchKeyword(keyword)

                    if (response.isSuccessful.not()) {
                        return
                    }

                    // body 가 null 이 아닐 때 books 를 return 하거나 또는 서치가 되지 않으면 빈 값을 주는
                    // 형식으로 코드 변경
                    adapter.submitList(response.body()?.books.orEmpty())
                }

                override fun onFailure(call: Call<SearchBookDto>, t: Throwable) {

                }

            })

    }

    private fun saveSearchKeyword(keyword: String) {
        Thread {
            db.historyDao().insertHistory(History(null, keyword))
        }.start()
    }

    private fun initBookRecyclerView() {
        adapter = BookAdapter()

        binding.bookRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.bookRecyclerView.adapter = adapter
    }

    private fun showHistoryView() {
        Thread {
            val keywords = db.historyDao().getAll().reversed()
        }

        binding.historyRecyclerView.isVisible = true
    }

    private fun hideHistoryView() {
        binding.historyRecyclerView.isVisible = false
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}