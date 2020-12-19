package com.example.scheduler1215.ui.display

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class DisplayInitializer(context: Context,layout: ConstraintLayout) : DisplayController(context){
    var timelineLayout:ConstraintLayout = layout
    var textViews : MutableList<View> = mutableListOf()
    var lines : MutableList<View> = mutableListOf()
    init {
        for(i in 0..24){
            val textView = TextView(context)
            var text = i.toString() + ":00"
            textView.text = text
            textViews.add(textView)
            textViews[i].id = View.generateViewId()
            timelineLayout.addView(textViews[i])
        }
        verticalChainInLayout(textViews, timelineLayout)
        val lineStyleSet = ConstraintSet()
        for(i in 0..24){
            lines.add(createLineView(timelineLayout,lineStyleSet))
//            lineStyleSet.constrainHeight(lines[i].id, 1.dp)
            lineStyleSet.connect(lines[i].id,ConstraintSet.START,textViews[i].id,ConstraintSet.END,10.dp)
            lineStyleSet.connect(lines[i].id,ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END,10.dp)
            lineStyleSet.connect(lines[i].id,ConstraintSet.TOP,textViews[i].id,ConstraintSet.TOP)
            lineStyleSet.connect(lines[i].id,ConstraintSet.BOTTOM,textViews[i].id,ConstraintSet.BOTTOM)
        }
        lineStyleSet.applyTo(timelineLayout)
    }
    fun setScheduleView(view: Button, hour:Int){
        timelineLayout.addView(view)
        val StyleSet = ConstraintSet()
        StyleSet.constrainHeight(view.id, ConstraintSet.MATCH_CONSTRAINT)
        StyleSet.constrainWidth(view.id, ConstraintSet.MATCH_CONSTRAINT)
        StyleSet.connect(view.id,ConstraintSet.START,lines[hour].id,ConstraintSet.START,4.dp)
        StyleSet.connect(view.id,ConstraintSet.END,lines[hour].id,ConstraintSet.END,4.dp)
        StyleSet.connect(view.id,ConstraintSet.TOP,lines[hour].id,ConstraintSet.TOP)
        StyleSet.connect(view.id,ConstraintSet.BOTTOM,lines[hour+1].id,ConstraintSet.BOTTOM)
        StyleSet.applyTo(timelineLayout)
    }
}