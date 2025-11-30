package com.example.moodmatch
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
class MovieAdapter(
    private val movies: List<Movie>,
    private val onItemClick: (Movie)->Unit
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    inner class MovieViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val poster:ImageView=itemView.findViewById(R.id.imagePoster)
        val title:TextView=itemView.findViewById(R.id.textTitle)
        val desc:TextView=itemView.findViewById(R.id.textDescription)
        val rating:RatingBar=itemView.findViewById(R.id.ratingBar)
        fun bind(m:Movie){
            poster.setImageResource(m.posterResId)
            title.text=m.title
            desc.text=m.description
            rating.rating=m.rating
            itemView.setOnClickListener{onItemClick(m)}
        }
    }
    override fun onCreateViewHolder(p:ViewGroup,v:Int)=MovieViewHolder(
        LayoutInflater.from(p.context).inflate(R.layout.item_movie,p,false)
    )
    override fun getItemCount()=movies.size
    override fun onBindViewHolder(h:MovieViewHolder,i:Int)=h.bind(movies[i])
}