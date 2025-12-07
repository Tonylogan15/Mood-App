package com.example.moodmatch.data

import android.util.Log
import com.example.moodmatch.network.TmdbApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MovieRepository {

    private const val TAG = "MovieRepository"

    // Map mood -> TMDB genre as STRING
    private fun genreForMood(rawMood: String): String {
        val mood = rawMood.lowercase().trim()

        return when {
            "happy" in mood   -> "35"    // Comedy
            "chill" in mood   -> "18"    // Drama
            "sad" in mood     -> "10749" // Romance
            "excited" in mood -> "28"    // Action
            else              -> "35"    // default: Comedy
        }
    }

    // Called from MovieListActivity inside lifecycleScope.launch
    suspend fun getMoviesForMood(mood: String): List<Movie> = withContext(Dispatchers.IO) {
        val genreId = genreForMood(mood)
        Log.d(TAG, "Requesting movies for mood='$mood', mappedGenreId=$genreId")

        return@withContext try {
            // 🔹 uses YOUR TmdbApiService from TmdbApiService.kt
            val response = TmdbApi.retrofitService.getMoviesByGenre(genreId)
            val movies = response.results

            Log.d(TAG, "TMDB returned ${movies.size} movies for genreId=$genreId")
            movies
        } catch (e: Exception) {
            Log.e(TAG, "Error loading movies for mood='$mood'", e)
            emptyList()
        }
    }
}
