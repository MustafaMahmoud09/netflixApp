package com.lomu.viewmodel.viewModel

import com.lomu.state.HomeUiState
import com.lomu.usecase.get.*
import com.lomu.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesTopRatedUseCase: GetMoviesTopRatedUseCase,
    private val getMovieUpcomingCase: GetMovieUpcomingCase,
    private val getMoviesLastWeekUseCase: GetMoviesLastWeekUseCase,
    private val getMoviesPopularUseCase: GetMoviesPopularUseCase,
    private val getMoviesNowPlayingUseCase: GetMoviesNowPlayingUseCase
) : BaseViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getHeaderMovies()
        getSubHeaderMovies()
        getPopularMovies()
        getTopRateMovies()
        getLastWeekMovies()
    }

    private fun getHeaderMovies() {

        val data = getMoviesNowPlayingUseCase(
            language = "en"
        )

        _state.update {
            it.copy(
                headerData = data
            )
        }
    }

    private fun getSubHeaderMovies() {

        val data = getMovieUpcomingCase(
            language = "en"
        )

        _state.update {
            it.copy(
                subHeaderData = data
            )
        }
    }

    private fun getPopularMovies() {

        val data = getMoviesPopularUseCase(
            language = "en"
        )

        _state.update {
            it.copy(
                popularData = data
            )
        }
    }

    private fun getTopRateMovies() {

        val data = getMoviesTopRatedUseCase(
            language = "en"
        )

        _state.update {
            it.copy(
                topRateData = data
            )
        }
    }

    private fun getLastWeekMovies() {

        val data = getMoviesLastWeekUseCase(
            language = "en"
        )

        _state.update {
            it.copy(
                lastWeekData = data
            )
        }
    }
}