package com.lomu.viewmodel.viewModel

import com.lomu.state.FavoriteUiState
import com.lomu.usecase.get.GetMovieFavoriteUseCase
import com.lomu.usecase.remove.RemoveMovieFavoriteUseCase
import com.lomu.usecase.set.SetMovieFavoriteUseCase
import com.lomu.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getMovieFavoriteUseCase: GetMovieFavoriteUseCase,
    private val removeMovieFavoriteUseCase: RemoveMovieFavoriteUseCase,
) : BaseViewModel() {

    private val _state = MutableStateFlow(FavoriteUiState())
    val state = _state.asStateFlow()

    init {
        getFavoriteMovies()
    }

    private fun getFavoriteMovies() {
        coroutineScope.launch(Dispatchers.IO) {
            getMovieFavoriteUseCase().debounce(1).collect { list ->
                _state.update {
                    it.copy(
                        data = list
                    )
                }
            }
        }
    }


    fun onCancelBottomSheet() {

        _state.update {
            it.copy(
                bottomSheet = 1
            )
        }
        onDeleteItem()
    }

    private fun onDeleteItem() {

        coroutineScope.launch(Dispatchers.IO) {
            removeMovieFavoriteUseCase(
                id = _state.value.itemDeleted
            )
        }
    }

    fun onShowBottomSheet(id: String) {
        _state.update {
            it.copy(
                bottomSheet = it.bottomSheet + 1,
                itemDeleted = id
            )
        }
    }

}