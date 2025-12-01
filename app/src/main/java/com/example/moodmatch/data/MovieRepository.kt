package com.example.moodmatch.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

class MovieRepository {

    private val client = OkHttpClient()


    private val apiKey = "36989a0eb8ed3f5408c93434403eb31f"

    private fun genreForMood(mood: String): Int {
        // super simple mapping; tweak if you want
        return when (mood.lowercase()) {
            "happy" -> 35   // Comedy
            "chill" -> 18   // Drama
            "sad" -> 10749  // Romance
            "excited" -> 28 // Action
            else -> 35
        }
    }

    suspend fun getMoviesForMood(mood: String): List<Movie> = withContext(Dispatchers.IO) {
        val genreId = genreForMood(mood)

        val url =
            "https://api.themoviedb.org/3/discover/movie" +
                    "?with_genres=$genreId" +
                    "&sort_by=popularity.desc" +
                    "&language=en-US" +
                    "&page=1" +
                    "&api_key=$apiKey"

        val request = Request.Builder()
            .url(url)
            .build()

        val response = client.newCall(request).execute()

        if (!response.isSuccessful) {
            throw IOException("Unexpected code $response")
        }

        val bodyString = response.body?.string() ?: throw IOException("Empty response body")

        val json = JSONObject(bodyString)
        val results = json.getJSONArray("results")

        val movies = mutableListOf<Movie>()

        for (i in 0 until results.length()) {
            val obj = results.getJSONObject(i)
            val title = obj.optString("title", "Unknown title")
            val overview = obj.optString("overview", "No overview available.")
            val rating = obj.optDouble("vote_average", 0.0).toFloat()

            movies.add(
                Movie(
                    title = title,
                    overview = overview,
                    rating = rating
                )
            )
        }

        movies
    }
}
