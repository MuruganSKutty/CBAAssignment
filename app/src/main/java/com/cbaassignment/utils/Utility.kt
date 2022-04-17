package com.cbaassignment.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun convertDate(str: String): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val convertedDate: Date?
    var formattedDate: String? = null
    try {
        convertedDate = sdf.parse(str)
        formattedDate = convertedDate?.let {
            SimpleDateFormat(
                "MMM d, yyyy h:mm a",
                Locale.getDefault()
            ).format(it)
        }
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    return formattedDate ?: ""
}