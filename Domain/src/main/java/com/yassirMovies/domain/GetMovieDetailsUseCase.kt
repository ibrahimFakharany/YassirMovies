package com.yassirMovies.domain

import com.yassirMovies.model.FullMovie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val moviesRepository: IMoviesRepository) {

    operator fun invoke(movieId: Long): Flow<FullMovie> {
        return moviesRepository.getMovieDetails(movieId)
    }
}