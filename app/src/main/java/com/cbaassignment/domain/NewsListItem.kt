package com.cbaassignment.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsListItem(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("urlToImage")
    val imageUrl: String,
    @SerializedName("publishedAt")
    val publishedDateTime: String
) : Parcelable