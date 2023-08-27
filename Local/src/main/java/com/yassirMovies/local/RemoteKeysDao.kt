package com.yassirMovies.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.yassirMovies.model.MovieRemoteKeys

@Dao
interface RemoteKeysDao {
    @Insert(onConflict = REPLACE)
    suspend fun saveKeys(keys: List<MovieRemoteKeys>)

    @Query("SELECT * FROM movies_remote_keys WHERE id=:id")
    suspend fun getKeys(id: Long): MovieRemoteKeys

    @Query("DELETE FROM movies_remote_keys")
    suspend fun clearAll()
}