package com.valjapan.spajampracticeandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class ThreadFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_thred, container, false)
        val intentAddThreadButton: Button = view.findViewById(R.id.intent_add_thread_fragment)
        intentAddThreadButton.setOnClickListener {
            findNavController().navigate(R.id.action_threadFragment_to_addThreadFragment)
        }
        return view
    }

}