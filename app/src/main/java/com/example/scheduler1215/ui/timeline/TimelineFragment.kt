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
    lateinit var fab:View

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
        fab = (activity as AppCompatActivity)!!.findViewById(R.id.floatingActionButton)
        fab.setOnClickListener{view ->
            val button = MaterialButton(activity as AppCompatActivity, null, R.attr.materialButtonStyle)
            button.id = View.generateViewId()
            button.setBackgroundColor(resources.getColor(R.color.material400_pink))
            button.text = "今日の予定"
            val button1 = MaterialButton(activity as AppCompatActivity, null, R.attr.materialButtonStyle)
            button1.id = View.generateViewId()
            button1.setBackgroundColor(resources.getColor(R.color.material400_green))
            button1.text = "今日の予定"
            displayInitializer.setScheduleView(button,2)
            displayInitializer.setScheduleView(button1, 3)
        }
        return root
    }

    fun getDate():String{
        var calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("MM月dd日（E）")
        return sdf.format(calendar.getTime())
    }
}