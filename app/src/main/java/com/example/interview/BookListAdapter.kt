package com.example.interview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.interview.databinding.BookListItemBinding
import com.example.interview.model.BookList
import com.example.interview.model.BookListItem

class BookListAdapter(private val bookList :BookList):RecyclerView.Adapter<BookListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<BookListItemBinding>(LayoutInflater.from(parent.context),R.layout.book_list_item,parent,false)
        return ViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return bookList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bookList[position])
    }
    class ViewHolder(private val binding: BookListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(bookListItem: BookListItem){
            binding.bookItem = bookListItem
        }
    }

}