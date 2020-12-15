package com.example.scheduler1215.ui.display

import android.content.Context
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.scheduler1215.R

open class DisplayController(val context: Context) {

    fun verticalChain(viewList:MutableList<View>, applyLayout: ConstraintLayout){
        val constraintSet = ConstraintSet()
        for(i in 0..viewList.lastIndex){
            constraintSet.constrainHeight(viewList[i].id, ConstraintSet.WRAP_CONTENT)
            constraintSet.constrainWidth(viewList[i].id, ConstraintSet.WRAP_CONTENT)
            if(i == 0){
                constraintSet.connect(viewList[i].id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
            }else{
                constraintSet.connect(viewList[i].id, ConstraintSet.TOP, viewList[i-1].id, ConstraintSet.BOTTOM, 0)
            }
            if(i == viewList.lastIndex){
                constraintSet.connect(viewList[i].id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
            }else{
                constraintSet.connect(viewList[i].id, ConstraintSet.BOTTOM, viewList[i+1].id, ConstraintSet.TOP, 0)
            }
        }
        constraintSet.applyTo(applyLayout)
    }

//    fun connectVerticalCenter(layout:ConstraintLayout,parent:View,child:View){
//        val styleSet = ConstraintSet()
//        styleSet.connect(child.id,ConstraintSet.TOP,parent.id,ConstraintSet.TOP)
//        styleSet.connect(child.id,ConstraintSet.BOTTOM,parent.id,ConstraintSet.BOTTOM)
//        layout.setConstraintSet(styleSet)
//    }
//
//    fun connectStartToEnd(layout:ConstraintLayout,parent:View,child:View,margin:Int){
//        val styleSet = ConstraintSet()
//        styleSet.connect(child.id,ConstraintSet.START,parent.id,ConstraintSet.END,margin)
//        layout.setConstraintSet(styleSet)
//    }
//
//    fun connectEndToEnd(layout: ConstraintLayout,parent: View,child: View, margin: Int){
//        val styleSet = ConstraintSet()
//        styleSet.connect(child.id,ConstraintSet.END,parent.id,ConstraintSet.END,margin)
//    }

    fun createLineView(layout:ConstraintLayout): View {
        val line = View(context)
        line.id = View.generateViewId()
        line.setBackgroundColor(ContextCompat.getColor(context, R.color.gray))
        layout.addView(line)
//        val lineStyleSet = ConstraintSet()
//        lineStyleSet.constrainWidth(line.id, ConstraintSet.MATCH_CONSTRAINT)
//        lineStyleSet.constrainHeight(line.id, 1.dp)
//        layout.setConstraintSet(lineStyleSet)
        return line
    }
}