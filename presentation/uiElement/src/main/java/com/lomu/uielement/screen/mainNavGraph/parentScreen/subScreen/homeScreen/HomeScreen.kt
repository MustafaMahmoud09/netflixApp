package com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.homeScreen


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.lomu.model.MovieHome
import com.lomu.uielement.element.lazyItem.FilmHomeItem
import com.lomu.netflix.ui.uiElement.element.lazyItem.Header
import com.lomu.uielement.R
import com.lomu.uielement.element.composable.TitleMedium
import com.lomu.uielement.element.lazyItem.HeaderSmall
import com.lomu.uielement.element.lazyItem.TitleCategory
import com.lomu.uielement.navGraph.navigateToMovieNavGraph
import com.lomu.uielement.stateScreen.ErrorScreen
import com.lomu.uielement.stateScreen.LoadingScreen
import com.lomu.uielement.theme.*
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.viewmodel.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    navRootController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    HomeContent(
        headerState = state.value.headerData?.collectAsLazyPagingItems(),
        subHeaderState = state.value.subHeaderData?.collectAsLazyPagingItems(),
        topRateState = state.value.topRateData?.collectAsLazyPagingItems(),
        popularState = state.value.popularData?.collectAsLazyPagingItems(),
        lastWeekState = state.value.lastWeekData?.collectAsLazyPagingItems(),
        onClickItem = { navRootController.navigateToMovieNavGraph(it) }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    theme: CustomColors = netflixTheme(),
    dimens: CustomDimens = netflixDimens(),
    headerState: LazyPagingItems<MovieHome>?,
    subHeaderState: LazyPagingItems<MovieHome>?,
    topRateState: LazyPagingItems<MovieHome>?,
    popularState: LazyPagingItems<MovieHome>?,
    lastWeekState: LazyPagingItems<MovieHome>?,
    onClickItem: (String) -> Unit,
) {
    val topRate = stringResource(id = R.string.top_rated)
    val lastWeek = stringResource(id = R.string.last_week)
    val popular = stringResource(id = R.string.popular)
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    dimens.dimen_1.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            TitleMedium(
                text = stringResource(id = R.string.netflix),
                dimens = dimens,
                theme = theme,
                color = theme.redIcon,
                size = dimens.dimen_3_5.toFloat(),
                font = openSansMedium
            )
        }
        AnimatedVisibility(
            visible = headerState?.loadState?.refresh is LoadState.Loading,
            enter = fadeIn(),
            exit = fadeOut(
                animationSpec = tween(100)
            )
        ) {
            LoadingScreen()
        }

        AnimatedVisibility(
            visible = headerState?.loadState?.refresh is LoadState.Error,
            enter = fadeIn(
                animationSpec = tween(100)
            ),
            exit = fadeOut(
                animationSpec = tween(100)
            )
        ) {
            ErrorScreen()
        }

        AnimatedVisibility(
            visible = headerState?.loadState?.refresh is LoadState.NotLoading,
            enter = fadeIn(
                animationSpec = tween(100)
            ),
            exit = fadeOut(
                animationSpec = tween(100)
            )
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(
                    vertical = dimens.dimen_1.dp
                ),
                verticalArrangement = Arrangement.spacedBy(
                    dimens.dimen_3.dp
                )
            ) {
                item(
                    key = 1
                ) {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(
                            horizontal = dimens.dimen_1.dp
                        ),
                        horizontalArrangement = Arrangement.spacedBy(
                            dimens.dimen_1.dp
                        )
                    ) {
                        items(headerState!!.itemCount) {
                            Header(
                                theme = theme,
                                dimen = dimens,
                                onClick = onClickItem,
                                movie = headerState.get(it)!!
                            )
                        }
                    }
                }

                item(
                    key = 2
                ) {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentPadding = PaddingValues(
                            horizontal = dimens.dimen_1.dp
                        ),
                        horizontalArrangement = Arrangement.spacedBy(
                            dimens.dimen_1.dp
                        )
                    ) {
                        if (subHeaderState?.loadState?.refresh is LoadState.NotLoading) {
                            items(subHeaderState.itemCount) {
                                HeaderSmall(
                                    theme = theme,
                                    dimen = dimens,
                                    movie = subHeaderState.get(it)!!,
                                    onClick = onClickItem
                                )
                            }
                        }
                    }
                }

                categoryMovie(
                    dimens = dimens,
                    theme = theme,
                    state = popularState,
                    title = popular,
                    onClickItem = onClickItem,
                    keySticky = 5,
                    keyItem = 6
                )

                categoryMovie(
                    dimens = dimens,
                    theme = theme,
                    state = topRateState,
                    title = topRate,
                    onClickItem = onClickItem,
                    keySticky = 3,
                    keyItem = 4
                )

                categoryMovie(
                    dimens = dimens,
                    theme = theme,
                    state = lastWeekState,
                    title = lastWeek,
                    onClickItem = onClickItem,
                    keySticky = 7,
                    keyItem = 8
                )

            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
fun LazyListScope.categoryMovie(
    dimens: CustomDimens,
    theme: CustomColors,
    state: LazyPagingItems<MovieHome>?,
    title: String,
    onClickItem: (String) -> Unit,
    keySticky: Int,
    keyItem: Int
) {

    if (state?.loadState?.refresh is LoadState.NotLoading) {
        stickyHeader(
            key = keySticky,
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(
                    horizontal = dimens.dimen_1.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.dimen_1.dp
                )
            ) {
                item {
                    TitleCategory(
                        dimens = dimens,
                        theme = theme,
                        text = title,
                        font = openSansCondensedSemiBold,
                    )
                }
            }
        }
        item(
            key = keyItem
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(
                    horizontal = dimens.dimen_1.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(
                    dimens.dimen_1.dp
                )
            ) {
                items(state.itemCount) {
                    FilmHomeItem(
                        theme = theme,
                        dimens = dimens,
                        movieHome = state.get(it)!!,
                        onClick = onClickItem
                    )
                }
            }
        }
    }
}