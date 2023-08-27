package com.ibrahim.yassirMovies.di

import android.content.Context
import com.yassirMovies.data.ILocalDataSource
import com.yassirMovies.local.LocalDataSource
import com.yassirMovies.local.MovieDao
import com.yassirMovies.local.MoviesDatabase
import com.yassirMovies.local.RemoteKeysDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {
    @Provides
    fun provideRemoteDataSource(
        postsDao: MovieDao,
        keysDao: RemoteKeysDao,
        database: MoviesDatabase
    ): ILocalDataSource = LocalDataSource(database, postsDao, keysDao)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MoviesDatabase {
        return MoviesDatabase.create(context)
    }

    @Provides
    fun provideMovieDao(database: MoviesDatabase): MovieDao {
        return database.getMovieDao()
    }

    @Provides
    fun provideRemoteKeysDao(database: MoviesDatabase): RemoteKeysDao {
        return database.getRemoteKeysDao()
    }

}