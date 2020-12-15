package com.example.scheduler1215.ui.timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.scheduler1215.R

class TimelineFragment : Fragment() {

    private lateinit var timelineViewModel: TimelineViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        timelineViewModel =
                ViewModelProvider(this).get(TimelineViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_timeline, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        timelineViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}