package com.example.scheduler1215.ui.display

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class DisplayInitializer(context: Context,layout: ConstraintLayout) : DisplayController(context){
    init {
        var textViews: MutableList<View> = mutableListOf()
        for(i in 0..24){
            val textView = TextView(context)
            var text = i.toString() + ":00"
            textView.text = text
            textViews.add(textView)
            textViews[i].id = View.generateViewId()
            layout.addView(textViews[i])
        }
        verticalChain(textViews, layout)
        val lines:MutableList<View> = mutableListOf()
//        for (i in 0..textViews.lastIndex){
//            lines.add(createLineView(layout))
//            connectVerticalCenter(layout,textViews[i],lines[i])
//            connectStartToEnd(layout,textViews[i],lines[i],10.dp)
//            connectEndToEnd(layout,layout,lines[i],10.dp)
//        }
        val lineStyleSet = ConstraintSet()
        for(i in 0..24){
            lines.add(createLineView(layout))
            lineStyleSet.constrainHeight(lines[i].id, 1.dp)
            lineStyleSet.connect(lines[i].id,ConstraintSet.START,textViews[i].id,ConstraintSet.END,10.dp)
            lineStyleSet.connect(lines[i].id,ConstraintSet.END,ConstraintSet.PARENT_ID,ConstraintSet.END,10.dp)
            lineStyleSet.connect(lines[i].id,ConstraintSet.TOP,textViews[i].id,ConstraintSet.TOP)
            lineStyleSet.connect(lines[i].id,ConstraintSet.BOTTOM,textViews[i].id,ConstraintSet.BOTTOM)
        }
        layout.setConstraintSet(lineStyleSet)
    }
}