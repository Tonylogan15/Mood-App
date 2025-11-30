package com.example.moodmatch
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Movie(
    val title: String,
    val description: String,
    val rating: Float,
    val posterResId: Int
) : Parcelable