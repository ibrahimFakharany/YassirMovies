package com.yassirMovies.remote

import com.yassirMovies.model.FullMovie
import com.yassirMovies.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("page") page: Int? = 1
    ): MovieListResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") postId: Long,
    ): FullMovie
}