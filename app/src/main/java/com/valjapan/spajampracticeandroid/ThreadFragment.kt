package com.valjapan.spajampracticeandroid

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.valjapan.spajampracticeandroid.databinding.FragmentThredBinding
import com.valjapan.spajampracticeandroid.databinding.ItemThreadsBinding


class ThreadFragment : Fragment() {

    private val viewModel by viewModels<ThreadViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentThredBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_thred, container, false)

        binding.threadRecyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        val adapter = ThreadRecyclerViewAdapter(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.getThreads()

        viewModel.threadList.observe(viewLifecycleOwner, Observer {
            adapter.setThreads(it)
        })


//        val threadRecyclerView = view.findViewById<RecyclerView>(R.id.thread_recycler_view)
//        threadRecyclerView.layoutManager = LinearLayoutManager(view.context)
//        threadRecyclerView.adapter = adapter
//        adapter.setThreads(viewModel.getThreads())
//
//        binding.threadRecyclerView.apply {
//            setHasFixedSize(true)
//
//        }
//
//        Log.d("TEST", viewModel.getThreads().toString())

        binding.intentAddThreadFragment.setOnClickListener {
            findNavController().navigate(R.id.action_threadFragment_to_addThreadFragment)
        }
        return binding.root
    }

}