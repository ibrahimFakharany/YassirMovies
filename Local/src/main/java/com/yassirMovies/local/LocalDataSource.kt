package com.yassirMovies.local

import androidx.paging.PagingSource
import androidx.room.withTransaction
import com.yassirMovies.data.ILocalDataSource
import com.yassirMovies.model.Movie
import com.yassirMovies.model.MovieRemoteKeys
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    val database: MoviesDatabase, val moviesDao: MovieDao, val keysDao: RemoteKeysDao
) : ILocalDataSource {

    override fun getMoviesPagingSource(): PagingSource<Int, Movie> {
        return moviesDao.getMovies()
    }


    override suspend fun getRemoteKeys(id: Long): MovieRemoteKeys {
        return keysDao.getKeys(id)
    }


    override suspend fun saveData(
        isRefresh: Boolean, movies: List<Movie>, keys: List<MovieRemoteKeys>
    ) = database.withTransaction {
        if (isRefresh) {
            keysDao.clearAll()
            moviesDao.clearAll()
        }
        keysDao.saveKeys(keys)
        moviesDao.saveMovies(movies)
    }

    override suspend fun clearAll() {
        withContext(Dispatchers.IO) {
            moviesDao.clearAll()
        }
    }

}