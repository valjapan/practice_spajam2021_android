package com.valjapan.spajampracticeandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.valjapan.spajampracticeandroid.databinding.FragmentThredBinding
import com.valjapan.spajampracticeandroid.network.Thread


class ThreadRecyclerViewAdapter(
    private val view: View
) : RecyclerView.Adapter<ThreadRecyclerViewAdapter.ViewHolder>() {

    private var threadList: MutableList<com.valjapan.spajampracticeandroid.network.Thread> =
        mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ThreadRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(view.context).inflate(R.layout.item_threads, parent, false)
        return ViewHolder(view)
    }

//    private fun getNews() {
//        val threadRepository: ThreadRepository = ThreadRepository(Url.BASE_URL)
//        threadRepository.getThreads().let {
//            it.body()
//        }
//    }

    override fun onBindViewHolder(holder: ThreadRecyclerViewAdapter.ViewHolder, position: Int) {
        val threads = threadList[position]


        if (threads != null) {
            holder.threadLength.text = threads.length.toString()
            holder.threadTimeStamp.text = threads.timestamp.toString()
            holder.threadTitle.text = threads.title
        }

    }


    fun setThreads(list: List<Thread>) {
        threadList.clear()
        threadList.addAll(list)
        notifyDataSetChanged()

    }


    override fun getItemCount(): Int = threadList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var threadLength: TextView = view.findViewById(R.id.thread_length)
        var threadTitle: TextView = view.findViewById(R.id.thread_title)
        var threadTimeStamp: TextView = view.findViewById(R.id.thread_timestamp)
    }

}