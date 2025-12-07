package com.example.moodmatch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moodmatch.data.Movie

class MovieAdapter(
    private val movies: List<Movie>,
    private val onItemClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    companion object {
        private const val TMDB_POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val posterImage: ImageView = itemView.findViewById(R.id.imagePoster)
        private val titleText: TextView = itemView.findViewById(R.id.textTitle)
        private val descriptionText: TextView = itemView.findViewById(R.id.textDescription)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)

        fun bind(movie: Movie) {
            titleText.text = movie.title
            descriptionText.text = movie.overview

            // TMDB 0–10 → RatingBar 0–5
            ratingBar.rating = (movie.rating / 2.0).toFloat()

            val url = movie.posterPath?.let { TMDB_POSTER_BASE_URL + it }
            Glide.with(itemView)
                .load(url)
                .into(posterImage)

            itemView.setOnClickListener {
                onItemClick(movie)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}
