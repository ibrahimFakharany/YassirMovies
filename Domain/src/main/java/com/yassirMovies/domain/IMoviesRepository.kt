package com.yassirMovies.domain

import androidx.paging.PagingData
import com.yassirMovies.model.FullMovie
import com.yassirMovies.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMoviesRepository {
    fun getMovies(): Flow<PagingData<Movie>>

    fun getMovieDetails(movieId: Long): Flow<FullMovie>
}