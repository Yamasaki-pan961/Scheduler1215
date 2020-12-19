package com.example.scheduler1215.ui.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private val _title = MutableLiveData<String>()
    val title : LiveData<String>
    get() = _title
    fun updateActionBarTitle(title:String)=_title.postValue(title)
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}