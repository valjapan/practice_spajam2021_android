package com.valjapan.spajampracticeandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.valjapan.spajampracticeandroid.network.ThreadRepository
import com.valjapan.spajampracticeandroid.network.ThreadRequest
import com.valjapan.spajampracticeandroid.network.Url
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddThreadFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_thred, container, false)
        val addButton: Button = view.findViewById(R.id.add_thread_title_button)
        val titleEditText: EditText = view.findViewById(R.id.add_thread_title)

        addButton.setOnClickListener {
            val title = titleEditText.text
            if (!title.isNullOrBlank()) {
                val threadRequest = ThreadRequest(title = title.toString())
                CoroutineScope(Dispatchers.IO).launch {
                    val api = ThreadRepository(Url.BASE_URL)
                    api.postThreads(threadRequest)

                }
            }
        }
        return view
    }


}