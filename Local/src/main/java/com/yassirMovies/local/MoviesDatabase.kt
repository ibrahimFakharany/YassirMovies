package com.yassirMovies.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yassirMovies.model.Movie
import com.yassirMovies.model.MovieRemoteKeys

@Database(
    entities = [Movie::class, MovieRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class MoviesDatabase : RoomDatabase() {
    companion object {
        fun create(context: Context): MoviesDatabase {
            val databaseBuilder =
                Room.databaseBuilder(context, MoviesDatabase::class.java, "movies_database.db")
            return databaseBuilder.build()
        }
    }

    abstract fun getMovieDao(): MovieDao
    abstract fun getRemoteKeysDao(): RemoteKeysDao
}