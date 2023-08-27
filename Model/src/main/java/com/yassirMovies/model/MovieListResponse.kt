package com.yassirMovies.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    val page: Int,
    @SerialName("results") val result: List<Movie>,
    @SerialName("total_pages") val totalPages: Int
)