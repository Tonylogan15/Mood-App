package com.example.moodmatch
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MovieDetailActivity:AppCompatActivity(){
    companion object{const val EXTRA_MOVIE="extra_movie"}
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val m:intent.getParcelableExtra<Movie>(EXTRA_MOVIE)!!
        findViewById<ImageView>(R.id.imagePosterDetail).setImageResource(m.posterResId)
        findViewById<TextView>(R.id.textTitleDetail).text=m.title
        findViewById<TextView>(R.id.textDescriptionDetail).text=m.description
        findViewById<RatingBar>(R.id.ratingBarDetail).rating=m.rating
        findViewById<TextView>(R.id.textRatingDetail).text="${m.rating}/5.0"
    }
}