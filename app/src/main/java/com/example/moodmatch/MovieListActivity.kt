package com.example.moodmatch

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moodmatch.data.Movie
import com.example.moodmatch.data.MovieRepository
import kotlinx.coroutines.launch

class MovieListActivity : ComponentActivity() {

    companion object {
        const val EXTRA_MOOD = "EXTRA_MOOD"
        private const val TAG = "MovieListActivity"
    }

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val mood = intent.getStringExtra(EXTRA_MOOD) ?: ""
        Log.d(TAG, "Mood from intent: '$mood'")

        loadMoviesForMood(mood)
    }

    private fun loadMoviesForMood(mood: String) {
        lifecycleScope.launch {
            val movies: List<Movie> = MovieRepository.getMoviesForMood(mood)

            if (movies.isEmpty()) {
                Toast.makeText(
                    this@MovieListActivity,
                    "No movies found for $mood",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val adapter = MovieAdapter(movies.toMutableList()) { movie ->
                val detailIntent = Intent(this@MovieListActivity, MovieDetailActivity::class.java)
                detailIntent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie)
                startActivity(detailIntent)
            }

            recyclerView.adapter = adapter
        }
    }
}
