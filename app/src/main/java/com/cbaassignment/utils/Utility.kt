package com.cbaassignment.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun convertDate(str: String): String{
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    var convertedDate: Date? = null
    var formattedDate: String? = null
    try {
        convertedDate = sdf.parse(str)
        formattedDate = SimpleDateFormat("MMM d,yyyy h:mm a", Locale.getDefault()).format(convertedDate)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    return formattedDate ?: ""
}