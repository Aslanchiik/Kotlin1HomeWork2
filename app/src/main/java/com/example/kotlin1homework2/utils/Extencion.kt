package com.example.kotlin1homework2.utils

import android.widget.EditText
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun EditText.getTextE() = text.toString().trim()

fun EditText.setErrorE(): String {
    if (getTextE().isEmpty()) {
        error = "Not Correct"
    }
    return getTextE()
}

fun ImageView.setImagePic(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}

