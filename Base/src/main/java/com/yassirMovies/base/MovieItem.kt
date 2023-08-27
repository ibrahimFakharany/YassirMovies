package com.yassirMovies.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.yassirMovies.model.Movie

@Composable
fun MovieItem(modifier: Modifier = Modifier, movie: Movie) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ), modifier = modifier.fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.padding(20.dp)) {
            SubcomposeAsyncImage(
                modifier = Modifier.width(150.dp).height(150.dp),
                model = "https://image.tmdb.org/t/p/w500/" + movie.posterPath,
                contentDescription = null,

                )
            Spacer(modifier = Modifier.width(14.dp))
            Column {
                Text(
                    movie.title, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(movie.releaseDate.split("-").first(), style = TextStyle(fontSize = 14.sp))
            }

        }
    }
}