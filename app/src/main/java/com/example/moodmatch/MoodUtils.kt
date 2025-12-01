package com.example.moodmatch.utils

object MoodUtils {

    // Returns a TMDB genre id for a given mood
    fun genreForMood(mood: String): String {
        return when (mood.lowercase()) {
            "happy" -> "35"     // Comedy
            "chill" -> "18"     // Drama
            "sad" -> "10749"    // Romance
            "excited" -> "28"   // Action
            else -> "35"
        }
    }
}
