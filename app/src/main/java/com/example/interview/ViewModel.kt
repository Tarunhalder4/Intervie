package com.example.interview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.interview.model.BookList
import com.example.interview.model.BookStatus
import com.example.interview.model.Result
import com.example.interview.model.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val application: Application,
    private val repository: Repository): AndroidViewModel(application) {

    private var _bookStatus = MutableLiveData<Result<BookStatus>>()
    val bookStatus:LiveData<Result<BookStatus>>
        get() = _bookStatus

    private var _bookList = MutableLiveData<Result<BookList>>()
    val bookList:LiveData<Result<BookList>>
        get() = _bookList

    fun getBookStatus(){
        _bookStatus.postValue(Result(Status.LOADING))
        viewModelScope.launch {
            repository.getStatus().enqueue(object :Callback<BookStatus>{
                override fun onResponse(call: Call<BookStatus>, response: Response<BookStatus>) {
                    _bookStatus.postValue(Result(Status.SUCCESS,response.body()))
                }

                override fun onFailure(call: Call<BookStatus>, t: Throwable) {
                    _bookStatus.postValue(Result(Status.ERROR, error = t.message))
                }
            })
        }
    }

    fun getBookList(){
        _bookList.postValue(Result(Status.LOADING))
        viewModelScope.launch {
            repository.getBooKList().enqueue(object :Callback<BookList>{
                override fun onResponse(call: Call<BookList>, response: Response<BookList>) {
                    _bookList.postValue(Result(Status.SUCCESS,response.body()))
                }
                override fun onFailure(call: Call<BookList>, t: Throwable) {
                    _bookList.postValue(Result(Status.ERROR, error = t.message))
                }
            })
        }

    }

}