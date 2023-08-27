package com.yassirMovies.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.yassirMovies.domain.IMoviesRepository
import com.yassirMovies.model.FullMovie
import com.yassirMovies.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class MoviesRepository @Inject constructor(
    val remoteDataSource: IRemoteDataSource, val localDataSource: ILocalDataSource
) : IMoviesRepository {

    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(config = PagingConfig(pageSize = PER_PAGE),
            remoteMediator = MoviesRemoteMediator(remoteDataSource, localDataSource),
            pagingSourceFactory = {
                localDataSource.getMoviesPagingSource()
            }).flow
    }

    override fun getMovieDetails(movieId: Long): Flow<FullMovie> {
        return flow { emit(remoteDataSource.getMovieDetails(movieId)) }
    }
}