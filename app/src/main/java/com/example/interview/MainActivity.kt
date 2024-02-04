package com.example.interview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.interview.databinding.ActivityMainBinding
import com.example.interview.model.BookList
import com.example.interview.model.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        booKStatusObserve()
        bookListObserve()

        binding.status.setOnClickListener {
            viewModel.getBookStatus()
        }

        binding.bookList.setOnClickListener {
            viewModel.getBookList()
        }


    }

    private fun booKStatusObserve(){
        viewModel.bookStatus.observe(this){
            when(it.status){
                Status.LOADING ->{
                    binding.pro.visibility = View.VISIBLE
                    binding.massage.visibility =View.GONE
                }
                Status.SUCCESS ->{
                    binding.pro.visibility = View.GONE
                    binding.massage.visibility =View.VISIBLE
                    binding.massage.text = it.data?.status
                }
                else ->{
                    binding.pro.visibility = View.GONE
                    binding.massage.visibility =View.VISIBLE
                    binding.massage.text  = it.error.toString()
                }
            }

        }
    }

    private fun bookListObserve(){
        viewModel.bookList.observe(this){
            when(it.status){
                Status.LOADING ->{
                    binding.pro.visibility = View.VISIBLE
                    binding.rec.visibility = View.GONE
                    binding.massage.visibility = View.GONE
                }
                Status.SUCCESS ->{
                    binding.pro.visibility = View.GONE
                    binding.rec.visibility = View.VISIBLE
                    binding.massage.visibility = View.GONE
                    val adapter = BookListAdapter(it.data as BookList)
                    binding.rec.adapter = adapter
                }
                else -> {
                    binding.pro.visibility = View.GONE
                    binding.rec.visibility = View.GONE
                    binding.massage.visibility = View.VISIBLE
                    binding.massage.text = it.error
                }
            }
        }

    }


}