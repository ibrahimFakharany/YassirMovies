package com.yassirMovies.featues.home

import com.yassirMovies.base.ViewEvent
import com.yassirMovies.base.ViewSideEffect
import com.yassirMovies.base.ViewState
import com.yassirMovies.model.Movie

class MoviesContract {
    sealed class HomeEvent : ViewEvent {
        class OnFromClicked : HomeEvent()
        class OnToClicked : HomeEvent()
    }

    sealed class HomeState : ViewState {
        object LoadingState : HomeState()
        class LoadingSuccessState(val posts: List<Movie>) : HomeState()
        object Error : HomeState()
    }

    sealed class HomeSideEffect : ViewSideEffect {
        class Error(val error: String) : HomeSideEffect()
    }
}