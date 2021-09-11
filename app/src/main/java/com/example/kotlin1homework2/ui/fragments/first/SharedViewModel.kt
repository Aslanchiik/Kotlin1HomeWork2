package com.example.kotlin1homework2.ui.fragments.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    val data :  MutableLiveData<ArrayList<String>> = MutableLiveData()

}