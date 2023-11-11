package com.lomu.viewmodel.viewModel

import com.lomu.state.SearchUiState
import com.lomu.usecase.get.GetMovieSearchUseCase
import com.lomu.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getMovieSearchUseCase: GetMovieSearchUseCase,
) : BaseViewModel() {

    private val _state = MutableStateFlow(SearchUiState())
    val state = _state.asStateFlow()

    init {
        onSearch()
    }

    fun onChangeKey(key: String) {

        _state.value.key.update {
            key
        }
    }

    fun onChangeInternetState(internet: Int) {

        _state.update {
            it.copy(
               internetState = internet
            )
        }
    }

    private fun onSearch() {

        coroutineScope.launch(Dispatchers.IO) {
            _state.value.key.debounce(300).collect {
                val data = getMovieSearchUseCase(
                    key = it,
                    language = "en"
                )
                _state.update { it ->
                    it.copy(
                        dataSearch = data
                    )
                }
            }
        }
    }

}


