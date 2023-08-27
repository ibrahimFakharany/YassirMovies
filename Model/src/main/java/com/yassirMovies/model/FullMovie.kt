package com.yassirMovies.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FullMovie(
    val id: Long,
    val title: String,
    @SerialName("release_date")  val releaseDate: String,
    @SerialName("poster_path") val posterPath: String,
    @SerialName("overview") val overview: String,
)