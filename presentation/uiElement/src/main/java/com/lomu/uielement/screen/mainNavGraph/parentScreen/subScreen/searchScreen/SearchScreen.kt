package com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.searchScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.lomu.model.MovieSearch
import com.lomu.uielement.R
import com.lomu.uielement.element.composable.ConnectionMessage
import com.lomu.uielement.element.composable.CustomProgress
import com.lomu.uielement.element.lazyItem.CardItemSearch
import com.lomu.uielement.element.lazyItem.FilmSearchItem
import com.lomu.uielement.navGraph.navigateToMovieNavGraph
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.netflixDimens
import com.lomu.uielement.theme.netflixTheme
import com.lomu.viewmodel.viewModel.SearchViewModel
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = hiltViewModel(),
    navRootController: NavHostController,
) {
    val state = searchViewModel.state.collectAsState()
    val result = state.value.dataSearch?.collectAsLazyPagingItems()
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        animationSpec = tween(300),
    )

    SearchContent(
        key = state.value.key.collectAsState().value,
        result = result,
        onChangeSearchKey = searchViewModel::onChangeKey,
        sheetState = sheetState,
        onChangeInternetState = searchViewModel::onChangeInternetState,
        internet = state.value.internetState,
        onClickOnMovie = { navRootController.navigateToMovieNavGraph(it) }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SearchContent(
    theme: CustomColors = netflixTheme(),
    dimen: CustomDimens = netflixDimens(),
    key: String,
    result: LazyPagingItems<MovieSearch>?,
    onChangeSearchKey: (String) -> Unit,
    onChangeInternetState: (Int) -> Unit,
    sheetState: ModalBottomSheetState,
    internet: Int,
    onClickOnMovie: (String) -> Unit
) {
    ModalBottomSheetLayout(
        sheetContent = {
            AnimatedVisibility(
                visible = internet == 1
            ) {
                ConnectionMessage(
                    dimen = dimen,
                    theme = theme,
                    background = theme.green,
                    title = stringResource(R.string.restored_internet)
                )
            }
            AnimatedVisibility(
                visible = internet == 0
            ) {
                ConnectionMessage(
                    dimen = dimen,
                    theme = theme,
                    background = theme.bottomBackground,
                    title = stringResource(R.string.not_connect),
                    textColor = theme.inflect
                )
            }
        },
        sheetState = sheetState
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CardItemSearch(
                text = key,
                onChange = onChangeSearchKey,
                dimens = dimen,
                theme = theme
            )


            AnimatedVisibility(
                visible = result?.loadState?.refresh is LoadState.Loading,
                enter = fadeIn(animationSpec = tween(300)),
                exit = fadeOut(animationSpec = tween(300))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CustomProgress(
                        theme = theme,
                        dimen = dimen
                    )
                }
            }

            AnimatedVisibility(
                visible = result?.loadState?.refresh is LoadState.Error,
            ) {
                onChangeInternetState(0)
            }

            AnimatedVisibility(
                visible = result?.loadState?.refresh is LoadState.NotLoading,
                enter = fadeIn(animationSpec = tween(300)),
                exit = fadeOut(animationSpec = tween(300))
            ) {
                if (internet == 0) {
                    onChangeInternetState(1)
                }
                LazyVerticalGrid(
                    state = rememberLazyGridState(),
                    columns = GridCells
                        .Adaptive(
                            minSize = dimen.dimen_16.dp
                        ),
                    contentPadding = PaddingValues(
                        vertical = dimen.dimen_1_5.dp,
                        horizontal = dimen.dimen_1.dp
                    ),
                    verticalArrangement = Arrangement
                        .spacedBy(
                            dimen.dimen_1.dp
                        ),
                    horizontalArrangement = Arrangement
                        .spacedBy(
                            dimen.dimen_1.dp
                        )
                ) {
                    result?.itemCount?.let {
                        items(
                            it
                        ) {
                            result.get(it)?.let { it1 ->
                                FilmSearchItem(
                                    dimens = dimen,
                                    theme = theme,
                                    movie = it1,
                                    onClick = onClickOnMovie
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(key1 = internet) {

        if (internet == 0) {
            sheetState.show()
        } else if (internet == 1) {
            sheetState.show()
            delay(2000)
            onChangeInternetState(2)
            sheetState.hide()
        }

    }
}
