package com.example.moodmatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moodmatch.data.Movie

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)


        val movie = intent.getSerializableExtra(EXTRA_MOVIE) as? Movie


    }
}
