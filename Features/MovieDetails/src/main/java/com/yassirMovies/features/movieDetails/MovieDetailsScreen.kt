package com.yassirMovies.features.movieDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.ramcosta.composedestinations.annotation.Destination

@Destination(navArgsDelegate = MovieDetailsNavArgs::class)
@Composable
fun MovieDetailsScreen() {
    MovieDetailsScreen(viewModel = hiltViewModel())
}

data class MovieDetailsNavArgs(
    val movieId: Long
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(viewModel: MovieDetailsViewModel) {
    val movieDetails = viewModel.state.collectAsState()
    when (movieDetails.value) {
        MovieDetailsContract.MovieDetailsState.MovieDetailsLoading -> {
            Box(modifier = Modifier.fillMaxSize()) {

                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        is MovieDetailsContract.MovieDetailsState.MovieDetailsFailed -> {
            ErrorView()
        }

        is MovieDetailsContract.MovieDetailsState.MovieDetailsSuccess -> {
            val movie =
                (movieDetails.value as MovieDetailsContract.MovieDetailsState.MovieDetailsSuccess).movie


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
                SubcomposeAsyncImage(

                    model = "https://image.tmdb.org/t/p/w500/" + movie.posterPath,
                    contentDescription = null,

                    )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    movie.title,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    movie.releaseDate.split("-").first(),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(fontSize = 16.sp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    movie.overview, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth()
                )
            }


        }
    }
}

@Composable
fun ErrorView() {
    Text("Error", style = TextStyle(color = Color.Red))
}