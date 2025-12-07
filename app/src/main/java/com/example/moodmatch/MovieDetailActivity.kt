package com.example.moodmatch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.bumptech.glide.Glide
import com.example.moodmatch.data.Movie

class MovieDetailActivity : ComponentActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        private const val TMDB_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        // Views
        val posterImageView: ImageView = findViewById(R.id.imagePoster)
        val titleTextView: TextView = findViewById(R.id.textTitle)
        val metaTextView: TextView = findViewById(R.id.textInfo)
        val overviewTextView: TextView = findViewById(R.id.textOverview)

        // Get movie from Intent
        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        if (movie == null) {
            finish()
            return
        }

        // Title
        titleTextView.text = movie.title

        // Year + rating
        val year = movie.releaseDate?.take(4) ?: "N/A"
        val rating = String.format("%.1f", movie.rating)
        metaTextView.text = "$year • $rating/10"

        // Overview
        overviewTextView.text =
            if (movie.overview.isNullOrBlank()) "No description available." else movie.overview

        // Poster
        movie.posterPath?.let { path ->
            val url = TMDB_IMAGE_BASE_URL + path
            Glide.with(this)
                .load(url)
                .into(posterImageView)
        }
    }
}

