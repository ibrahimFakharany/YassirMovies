package com.yassirMovies.remote

import com.yassirMovies.data.IRemoteDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val service: MoviesService) : IRemoteDataSource {
    override suspend fun fetchMovies(page: Int) = service.getMovies(page)
    override suspend fun getMovieDetails(movieId: Long) =
        service.getMovieDetails(movieId)
}