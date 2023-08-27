package com.yassirMovies.features.movieDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.yassirMovies.base.BaseViewModel
import com.yassirMovies.base.ViewEvent
import com.yassirMovies.base.ViewSideEffect
import com.yassirMovies.domain.GetMovieDetailsUseCase
import com.yassirMovies.features.movieDetails.destinations.MovieDetailsScreenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getMovieDetailsUseCase: GetMovieDetailsUseCase,
) : BaseViewModel<MovieDetailsContract.MovieDetailsState, ViewEvent, ViewSideEffect>() {
    val movieId = MovieDetailsScreenDestination.argsFrom(savedStateHandle).movieId

    init {
        viewModelScope.launch {
            launchRequest(getMovieDetailsUseCase(movieId), onStart = {
                MovieDetailsContract.MovieDetailsState.MovieDetailsLoading
            }, onSuccess = {
                setState {
                    MovieDetailsContract.MovieDetailsState.MovieDetailsSuccess(it)
                }
            }, onError = {
                setState {
                    MovieDetailsContract.MovieDetailsState.MovieDetailsFailed(it)
                }
            })
        }
    }

    override fun setInitialState(): MovieDetailsContract.MovieDetailsState =
        MovieDetailsContract.MovieDetailsState.MovieDetailsLoading

    override fun handleEvents(event: ViewEvent) {

    }
}