package com.yassirMovies.domain

import androidx.paging.PagingData
import com.yassirMovies.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val moviesRepository: IMoviesRepository) {

    operator fun invoke(): Flow<PagingData<Movie>> {
        return moviesRepository.getMovies()
    }
}