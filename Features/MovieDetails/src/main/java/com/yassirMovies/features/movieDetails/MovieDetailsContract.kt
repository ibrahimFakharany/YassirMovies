package com.yassirMovies.features.movieDetails

import com.yassirMovies.base.ViewState
import com.yassirMovies.model.FullMovie

class MovieDetailsContract {
    sealed class MovieDetailsState : ViewState {
        object MovieDetailsLoading : MovieDetailsState()
        data class MovieDetailsSuccess(val movie: FullMovie) : MovieDetailsState()
        data class MovieDetailsFailed(val error: String) : MovieDetailsState()

    }

}