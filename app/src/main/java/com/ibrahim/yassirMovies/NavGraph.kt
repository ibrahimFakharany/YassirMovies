package com.ibrahim.yassirMovies

import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import com.yassirMovies.featues.home.destinations.HomeScreenDestination
import com.yassirMovies.features.movieDetails.destinations.MovieDetailsScreenDestination

object NavGraph {
    val moviesGraph = object : NavGraphSpec {
        override val route = "movies"

        override val startRoute = HomeScreenDestination routedIn this

        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            HomeScreenDestination, MovieDetailsScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val root = object : NavGraphSpec {
        override val route: String = "root"

        override val startRoute: Route = moviesGraph

        override val destinationsByRoute: Map<String, DestinationSpec<*>> = emptyMap()
        override val nestedNavGraphs: List<NavGraphSpec> = listOf(
            moviesGraph,
        )
    }
}