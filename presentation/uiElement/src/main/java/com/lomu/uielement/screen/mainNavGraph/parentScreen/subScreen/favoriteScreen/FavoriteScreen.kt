package com.lomu.uielement.screen.mainNavGraph.parentScreen.subScreen.favoriteScreen


import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.lomu.state.FavoriteUiState
import com.lomu.uielement.R
import com.lomu.uielement.element.composable.TitleMedium
import com.lomu.uielement.element.lazyItem.FavoriteOpItem
import com.lomu.uielement.element.lazyItem.MovieFavoriteItem
import com.lomu.uielement.navGraph.navigateToMovieNavGraph
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.netflixDimens
import com.lomu.uielement.theme.netflixTheme
import com.lomu.uielement.theme.openSansMedium
import com.lomu.viewmodel.viewModel.FavoriteViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteScreen(
    navRootController: NavHostController,
    viewModel: FavoriteViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()

    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        animationSpec = tween(300),
    )

    val listOperator = listOf(
        OperatorFavorite(
            icon = R.drawable.bookmark,
            title = stringResource(
                R.string.cancel_saving
            ),
            onClick = viewModel::onCancelBottomSheet
        ),
    )

    FavoriteContent(
        bottomSheetState = bottomSheetState,
        settingList = listOperator,
        state = state.value,
        onShowMenu = viewModel::onShowBottomSheet,
        onClickOnItem = { navRootController.navigateToMovieNavGraph(it) }
    )

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteContent(
    theme: CustomColors = netflixTheme(),
    dimens: CustomDimens = netflixDimens(),
    bottomSheetState: ModalBottomSheetState,
    settingList: List<OperatorFavorite>,
    state: FavoriteUiState,
    onShowMenu: (String) -> Unit,
    onClickOnItem: (String) -> Unit
) {

    ModalBottomSheetLayout(
        sheetContent = {

            LazyColumn {

                items(settingList.size) {

                    FavoriteOpItem(
                        theme = theme,
                        dimens = dimens,
                        icon = settingList[it].icon,
                        text = settingList[it].title,
                        onClick = settingList[it].onClick
                    )

                }

            }

        },
        sheetState = bottomSheetState,
    ) {
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(
                    dimens.dimen_1.dp
                ),
                verticalArrangement = Arrangement
                    .spacedBy(
                        dimens.dimen_1.dp
                    )
            ) {

                items(
                    state.data.size,
                    key = { state.data[it].id }
                ) {
                    MovieFavoriteItem(
                        theme = theme,
                        dimens = dimens,
                        onClick = onShowMenu,
                        movie = state.data[it],
                        onClickOnItem = onClickOnItem
                    )
                }

            }
        }
    }
    LaunchedEffect(key1 = state.bottomSheet) {

        if (state.bottomSheet > 1) {

            bottomSheetState.show()
        } else {

            bottomSheetState.hide()
        }

    }
}



