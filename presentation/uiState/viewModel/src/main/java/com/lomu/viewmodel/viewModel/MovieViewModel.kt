package com.lomu.viewmodel.viewModel

import androidx.paging.map
import com.lomu.model.Movie
import com.lomu.model.MovieFavorite
import com.lomu.state.MovieUiState
import com.lomu.usecase.check.CheckMovieUseCase
import com.lomu.usecase.get.GetMovieCastUseCase
import com.lomu.usecase.get.GetMovieUseCase
import com.lomu.usecase.remove.RemoveMovieFavoriteUseCase
import com.lomu.usecase.set.SetMovieFavoriteUseCase
import com.lomu.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    private val getMovieCastUseCase: GetMovieCastUseCase,
    private val checkMovieUseCase: CheckMovieUseCase,
    private val setMovieFavoriteUseCase: SetMovieFavoriteUseCase,
    private val removeMovieFavoriteUseCase: RemoveMovieFavoriteUseCase,
    @Named("movie_id") private val movieId: String
) : BaseViewModel() {

    private val _state = MutableStateFlow(MovieUiState())
    val state = _state.asStateFlow()

    init {
//        onChangeMovieId()
        checkMovieFavoriteOrNo()
        getMovieDetails()
        getMovieCast()
    }

    fun onChangeMovieId(
        movieId: String
    ) {
        _state.value.movieId.update {
            movieId
        }
    }

    fun onChangeHeartState(
        movie: Movie
    ) {

        _state.update {
            it.copy(
                saved = !_state.value.saved
            )
        }

        deleteOrAddMovieFavorite(
            movie = movie
        )
    }

    private fun deleteOrAddMovieFavorite(
        movie: Movie
    ) {
        coroutineScope.launch {
            if (_state.value.saved) {
                setMovieFavoriteUseCase(
                    movieFavorite = MovieFavorite(
                        id = movie.id.toString(),
                        title = movie.title,
                        path = movie.image,
                        vote = movie.vote
                    )
                )
            } else {
                removeMovieFavoriteUseCase(
                    id = movie.id.toString()
                )
            }
        }
    }

    private fun checkMovieFavoriteOrNo() {

        coroutineScope.launch {
            _state.value.movieId.debounce(1).collect {

                val check = checkMovieUseCase(
                    id = _state.value.movieId.value
                )

                _state.update {
                    it.copy(
                        saved = check
                    )
                }
            }
        }
    }

    private fun getMovieCast() {

        coroutineScope.launch {
            _state.value.movieId.debounce(1).collect {
                val data = getMovieCastUseCase(
                    id = _state.value.movieId.value
                )

                _state.update {
                    it.copy(
                        movieCast = data
                    )
                }
            }
        }
    }

    private fun getMovieDetails() {

        coroutineScope.launch {
            _state.value.movieId.debounce(1).collect {
                val data = getMovieUseCase(
                    id = _state.value.movieId.value
                )

                _state.update {
                    it.copy(
                        movieDetail = data
                    )
                }
            }
        }
    }
}