package com.example.kotlin1homework2.ui.fragments.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

class SharedViewModel : ViewModel() {

    val data: MutableLiveData<String> = MutableLiveData()
    var url: ArrayList<String> = ArrayList()
    var list: MutableLiveData<List<String>> = MutableLiveData()


    fun addImage(image: String) {
        data.value = image
    }

    fun listImage(): MutableLiveData<List<String>> {
        url = arrayListOf(
            "https://i.pinimg.com/564x/9f/c3/c2/9fc3c2d2989592e70c9464b23195a11c.jpg",
            "https://i.pinimg.com/236x/94/82/66/948266a93475b224e486167e4dcd6740.jpg",
            "https://i.pinimg.com/236x/11/88/17/1188171ba61d2b6d2e940826826ca203.jpg",
            "https://i.pinimg.com/564x/98/13/33/981333a599250e2fa60e6e073eb304be.jpg",
            "https://i.pinimg.com/236x/c7/83/ac/c783ac40e146ee618a3090f87af57c47.jpg"
        )
        list.value = url
        return list
    }

    fun updateImage(urlEt: String) {
        url.add(urlEt)
        list.value = url
    }

    fun random(): String {
        return url[Random().nextInt(url.size)]
    }

}