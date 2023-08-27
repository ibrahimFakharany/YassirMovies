package com.yassirMovies.featues.home

import androidx.lifecycle.ViewModel
import com.yassirMovies.domain.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
    val movies = getMoviesUseCase()
}