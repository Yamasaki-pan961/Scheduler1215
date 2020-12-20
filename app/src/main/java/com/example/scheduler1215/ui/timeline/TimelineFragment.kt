package com.example.scheduler1215.ui.timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.scheduler1215.R
import com.example.scheduler1215.ui.display.DisplayInitializer
import com.example.scheduler1215.ui.display.dp
import com.google.android.material.button.MaterialButton
import java.text.SimpleDateFormat
import java.util.*



class TimelineFragment() : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_timeline, container, false)
        val timelineMainLayout : ConstraintLayout = root.findViewById(R.id.mainLayout)

        val displayInitializer = DisplayInitializer(activity as AppCompatActivity, timelineMainLayout)
        timelineMainLayout.layoutParams.height=1500.dp
        var title = getDate()
        (activity as AppCompatActivity)!!.supportActionBar!!.title = title
        return root
    }

    fun getDate():String{
        var calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("MM月dd日（E）")
        return sdf.format(calendar.getTime())
    }
}