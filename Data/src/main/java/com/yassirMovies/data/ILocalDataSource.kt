package com.yassirMovies.data

import androidx.paging.PagingSource
import com.yassirMovies.model.Movie
import com.yassirMovies.model.MovieRemoteKeys

interface ILocalDataSource {
    fun getMoviesPagingSource(): PagingSource<Int, Movie>
    suspend fun getRemoteKeys(id: Long): MovieRemoteKeys
    suspend fun saveData(
        isRefresh: Boolean, movies: List<Movie>, keys: List<MovieRemoteKeys>
    )

    suspend fun clearAll()
}