package com.example.moodmatch
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MovieListActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val rv=findViewById<RecyclerView>(R.id.recyclerViewMovies)
        rv.layoutManager=LinearLayoutManager(this)
        val movies=listOf(
            Movie("Happy","Feel good",4.5f,R.drawable.ic_launcher_foreground),
            Movie("Chill","Relaxing",4.0f,R.drawable.ic_launcher_foreground)
        )
        rv.adapter=MovieAdapter(movies){
            val i=Intent(this,MovieDetailActivity::class.java)
            i.putExtra(MovieDetailActivity.EXTRA_MOVIE,it)
            startActivity(i)
        }
    }
}