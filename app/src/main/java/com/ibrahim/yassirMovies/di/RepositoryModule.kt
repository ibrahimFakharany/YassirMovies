package com.ibrahim.yassirMovies.di

import com.yassirMovies.data.ILocalDataSource
import com.yassirMovies.data.IRemoteDataSource
import com.yassirMovies.data.MoviesRepository
import com.yassirMovies.domain.IMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun providePostsRepository(
        remoteDataSource: IRemoteDataSource,
        localDataSource: ILocalDataSource,
    ): IMoviesRepository = MoviesRepository(remoteDataSource, localDataSource)

}