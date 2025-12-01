package com.example.moodmatch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moodmatch.data.Movie

class MovieAdapter(
    private var movies: List<Movie>,
    private val onClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    fun updateMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.textTitle)
        private val overviewView: TextView = itemView.findViewById(R.id.textDescription)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)

        fun bind(movie: Movie) {
            titleView.text = movie.title
            overviewView.text = movie.overview
            ratingBar.rating = movie.rating / 2f  // TMDB is /10, RatingBar is /5

            itemView.setOnClickListener {
                onClick(movie)
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
