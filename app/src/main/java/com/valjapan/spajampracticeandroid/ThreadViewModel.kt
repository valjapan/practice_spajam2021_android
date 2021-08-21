package com.valjapan.spajampracticeandroid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.valjapan.spajampracticeandroid.network.Thread
import com.valjapan.spajampracticeandroid.network.ThreadRepository
import com.valjapan.spajampracticeandroid.network.Url
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThreadViewModel(application: Application) : AndroidViewModel(application) {

    private val threads: MutableList<Thread> = mutableListOf()
    val threadList = MutableLiveData<List<Thread>>()
    private val threadRepository: ThreadRepository = ThreadRepository(Url.BASE_URL)

    fun getThreads() {
        viewModelScope.launch(Dispatchers.IO) {
            for (i in threadRepository.getThreads()!!.body()!!.threads) {
                threads.add(i)
            }
            threadList.postValue(threads)
        }


    }
}