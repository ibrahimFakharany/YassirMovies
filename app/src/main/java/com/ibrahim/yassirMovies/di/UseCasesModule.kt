package com.ibrahim.yassirMovies.di

import com.yassirMovies.domain.GetMovieDetailsUseCase
import com.yassirMovies.domain.GetMoviesUseCase
import com.yassirMovies.domain.IMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {
    @Provides
    fun provideGetMoviesUseCase(
        moviesRepository: IMoviesRepository,
    ): GetMoviesUseCase = GetMoviesUseCase(moviesRepository)

    @Provides
    fun provideGetMovieDetailsUseCase(
        moviesRepository: IMoviesRepository,
    ): GetMovieDetailsUseCase = GetMovieDetailsUseCase(moviesRepository)
}