package com.yassirMovies.data

import com.yassirMovies.model.FullMovie
import com.yassirMovies.model.MovieListResponse

interface IRemoteDataSource {
    suspend fun fetchMovies(page: Int): MovieListResponse
    suspend fun getMovieDetails(movieId: Long) : FullMovie
}