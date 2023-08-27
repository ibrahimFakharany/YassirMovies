package com.ibrahim.yassirMovies

import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.dynamic.within
import com.ramcosta.composedestinations.navigation.navigateTo
import com.yassirMovies.featues.home.HomeScreenNavigator
import com.yassirMovies.features.movieDetails.destinations.MovieDetailsScreenDestination

class AppNavigator(val navigator: NavHostController) : HomeScreenNavigator {
    override fun navigateToMovieDetails(movieId: Long) {
        navigator.navigateTo(MovieDetailsScreenDestination(movieId) within NavGraph.moviesGraph)
    }
}