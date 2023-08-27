package com.yassirMovies.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.yassirMovies.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("SELECT * FROM movie_table")
    fun getMovies(): PagingSource<Int, Movie>

    @Query("DELETE FROM movie_table")
    fun clearAll()
}