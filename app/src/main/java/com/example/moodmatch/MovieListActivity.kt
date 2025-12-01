package com.example.moodmatch

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moodmatch.data.Movie
import com.example.moodmatch.data.MovieRepository
import kotlinx.coroutines.launch

class MovieListActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private val repository = MovieRepository()
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        recyclerView = findViewById(R.id.recyclerViewMovies)
        progressBar = findViewById(R.id.progressBar)

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MovieAdapter(emptyList()) { movie ->
            // For now just show a toast when you tap a movie
            Toast.makeText(this, movie.title, Toast.LENGTH_SHORT).show()
            // later: startActivity to MovieDetailActivity with movie info
        }
        recyclerView.adapter = adapter

        val mood = intent.getStringExtra("MOOD") ?: "happy"
        loadMovies(mood)
    }

    private fun loadMovies(mood: String) {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE

        lifecycleScope.launch {
            try {
                val movies: List<Movie> = repository.getMoviesForMood(mood)
                adapter.updateMovies(movies)
                recyclerView.visibility = View.VISIBLE
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(
                    this@MovieListActivity,
                    "Failed to load movies: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            } finally {
                progressBar.visibility = View.GONE
            }
        }
    }
}
