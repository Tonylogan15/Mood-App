package com.example.moodmatch.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.moodmatch.data.MovieResponse


private const val TMDB_API_KEY = "36989a0eb8ed3f5408c93434403eb31f"


private const val BASE_URL = "https://api.themoviedb.org/3/"


private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface TmdbApiService {


    @GET("discover/movie")
    suspend fun getMoviesByGenre(
        @Query("with_genres") genreId: String,
        @Query("api_key") apiKey: String = TMDB_API_KEY
    ): MovieResponse
}


object TmdbApi {
    val retrofitService: TmdbApiService by lazy {
        retrofit.create(TmdbApiService::class.java)
    }
}