package com.yassirMovies.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.yassirMovies.model.Movie
import com.yassirMovies.model.MovieRemoteKeys

const val PER_PAGE = 10

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator constructor(
    private val remoteDataSource: IRemoteDataSource, private val localDataSource: ILocalDataSource
) : RemoteMediator<Int, Movie>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Movie>): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1

                }

                LoadType.PREPEND -> {
                    return MediatorResult.Success(true)
                }

                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }
            }

            val response = remoteDataSource.fetchMovies(page = currentPage)
            val endOfPaginationReached = response.page >= response.totalPages
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            val keys = response.result.map { movie ->
                MovieRemoteKeys(
                    id = movie.id.toString(), nextPage = nextPage
                )
            }

            localDataSource.saveData(
                isRefresh = loadType == LoadType.REFRESH, keys = keys, movies = response.result
            )

            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Movie>
    ): MovieRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                localDataSource.getRemoteKeys(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, Movie>
    ): MovieRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { movie ->
            localDataSource.getRemoteKeys(id = movie.id)
        }
    }


}