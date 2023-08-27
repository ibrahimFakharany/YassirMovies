package com.yassirMovies.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey(autoGenerate = true) val tableId: Int = 0,
    val id: Long,
    val title: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("poster_path") val posterPath: String,
)