package com.lomu.uielement.screen.movieNavGraph.movieDistention


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.lomu.model.Movie
import com.lomu.model.MovieCast
import com.lomu.uielement.R
import com.lomu.uielement.element.lazyItem.CastItem
import com.lomu.uielement.element.lazyItem.TitleCategory
import com.lomu.uielement.element.modifier.shadow
import com.lomu.uielement.screen.BaseScreen
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.netflixDimens
import com.lomu.uielement.theme.netflixTheme
import com.lomu.uielement.theme.openSansMedium
import com.lomu.uielement.element.composable.*
import com.lomu.uielement.navGraph.MovieArg
import com.lomu.uielement.stateScreen.ErrorScreen
import com.lomu.uielement.stateScreen.LoadingScreen
import com.lomu.viewmodel.viewModel.MovieViewModel


@Composable
fun MovieScreen(
    viewModel: MovieViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    LaunchedEffect(key1 = true) {
        viewModel.onChangeMovieId(MovieArg.MOVIE_ID)
    }
    MovieContent(
        stateDetail = state.value.movieDetail?.collectAsLazyPagingItems(),
        stateCast = state.value.movieCast?.collectAsLazyPagingItems(),
        heartState = state.value.saved,
        onClickOnHeart = viewModel::onChangeHeartState
    )
}

@Composable
private fun MovieContent(
    theme: CustomColors = netflixTheme(),
    dimens: CustomDimens = netflixDimens(),
    stateDetail: LazyPagingItems<Movie>?,
    stateCast: LazyPagingItems<MovieCast>?,
    heartState: Boolean,
    onClickOnHeart: (Movie) -> Unit
) {

    BaseScreen(
        theme = theme,
        top = theme.infCardColor
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = theme.background)
            ) {

                when (stateDetail?.loadState?.refresh) {
                    is LoadState.Loading -> {
                        LoadingScreen()
                    }
                    is LoadState.Error -> {
                        ErrorScreen()
                    }
                    is LoadState.NotLoading -> {
                        ConstraintLayout(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    color = theme.background
                                )
                        ) {
                            val (coverCard, buttonStart, plus, love, titleMovie, info, columnInfo, titleCast, personCast, description, constrainItems) = createRefs()
                            val guideLineTop45P = guideLineTop45P()
                            val guideLineTop405P = guideLineTop405P()
                            val guideLineTop495P = guideLineTop495P()

                            val painter = rememberAsyncImagePainter(
                                model = ImageRequest
                                    .Builder(
                                        LocalContext.current
                                    ).data(
                                        stateDetail?.get(0)?.image
                                    ).size(
                                        coil.size.Size.ORIGINAL
                                    ).build()
                            )

                            val state = painter.state

                            if (state is AsyncImagePainter.State.Loading) {
                                Box(
                                    modifier = Modifier
                                        .constrainAs(coverCard) {
                                            top.linkTo(parent.top)
                                            start.linkTo(parent.start)
                                            end.linkTo(parent.end)
                                            bottom.linkTo(guideLineTop45P)
                                            width = Dimension.fillToConstraints
                                            height = Dimension.fillToConstraints
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    CustomProgress(
                                        theme = theme,
                                        dimen = dimens,
                                        size = dimens.dimen_5
                                    )
                                }
                            }

                            if (state is AsyncImagePainter.State.Error) {
                                Box(
                                    modifier = Modifier
                                        .constrainAs(coverCard) {
                                            top.linkTo(parent.top)
                                            start.linkTo(parent.start)
                                            end.linkTo(parent.end)
                                            bottom.linkTo(guideLineTop45P)
                                            width = Dimension.fillToConstraints
                                            height = Dimension.fillToConstraints
                                        }
                                        .clip(
                                            RoundedCornerShape(
                                                bottomEndPercent = 0,
                                                bottomStartPercent = 0,
                                            )
                                        )
                                        .padding(dimens.dimen_4.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        painter = painterResource(
                                            id = R.drawable.place_dark
                                        ),
                                        contentDescription = "empty",
                                        tint = theme.redIcon
                                    )
                                }
                            }
                            if (state is AsyncImagePainter.State.Success) {
                                Box(
                                    modifier = Modifier
                                        .constrainAs(coverCard) {
                                            top.linkTo(parent.top)
                                            start.linkTo(parent.start)
                                            end.linkTo(parent.end)
                                            bottom.linkTo(guideLineTop45P)
                                            width = Dimension.fillToConstraints
                                            height = Dimension.fillToConstraints
                                        }
                                        .shadow(
                                            theme = theme,
                                            dimens = dimens,
                                            shape = RoundedCornerShape(
                                                bottomEndPercent = 60,
                                                bottomStartPercent = 60,
                                            ),
                                            elevation = dimens.dimen_0_25
                                        )
                                        .clip(
                                            RoundedCornerShape(
                                                bottomEndPercent = 60,
                                                bottomStartPercent = 60,
                                            )
                                        )
                                ) {
                                    HomeImage(
                                        src = painter,
                                        description = "cover"
                                    )
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .constrainAs(buttonStart) {
                                        top.linkTo(guideLineTop405P)
                                        bottom.linkTo(guideLineTop495P)
                                        start.linkTo(parent.start)
                                        end.linkTo(parent.end)
                                        height = Dimension.fillToConstraints
                                    }
                                    .aspectRatio(1f)
                                    .shadow(
                                        theme = theme,
                                        dimens = dimens,
                                        shape = RoundedCornerShape(
                                            percent =  90
                                        ),
                                        elevation = dimens.dimen_0_25
                                    )
                                    .clip(
                                        RoundedCornerShape(
                                            percent =  90
                                        )
                                    )
                                    .background(
                                        color = theme.bottomBackground
                                    )
                                    .clickable { },
                                contentAlignment = Alignment.Center
                            ) {
                                StartIcon(
                                    theme = theme,
                                    color = theme.redIcon,
                                    painter = painterResource(
                                        id = R.drawable.play_button_arrowhead
                                    ),
                                    modifier = Modifier
                                        .size(
                                            dimens.dimen_4.dp
                                        )
                                )
                            }
                            StartIcon(
                                theme = theme,
                                color = theme.inflect,
                                painter = painterResource(
                                    id = R.drawable.add
                                ),
                                modifier = Modifier
                                    .constrainAs(plus) {
                                        top.linkTo(
                                            guideLineTop45P,
                                            dimens.dimen_4.dp
                                        )
                                        start.linkTo(
                                            parent.start,
                                            dimens.dimen_4.dp
                                        )
                                    }
                                    .size(dimens.dimen_3_5.dp)
                            )

                            StartIcon(
                                theme = theme,
                                color = if (heartState) theme.redIcon else theme.inflect,
                                painter = painterResource(
                                    id = R.drawable.heart_netflix
                                ),
                                modifier = Modifier
                                    .constrainAs(love) {
                                        top.linkTo(
                                            guideLineTop45P,
                                            dimens.dimen_4.dp
                                        )
                                        end.linkTo(
                                            parent.end,
                                            dimens.dimen_4.dp
                                        )
                                    }
                                    .size(dimens.dimen_3_5.dp)
                                    .clickable { onClickOnHeart(stateDetail?.get(0)!!) }
                            )

                            ConstraintLayout(
                                modifier = Modifier
                                    .verticalScroll(rememberScrollState())
                                    .safeDrawingPadding()
                                    .constrainAs(titleMovie) {
                                        top.linkTo(plus.bottom, -(dimens.dimen_2).dp)
                                        start.linkTo(parent.start)
                                        end.linkTo(parent.end)
                                        bottom.linkTo(parent.bottom)
                                        height = Dimension.fillToConstraints
                                    },
                            ) {
                                ConstraintLayout(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .constrainAs(constrainItems) {
                                            start.linkTo(parent.start)
                                            end.linkTo(parent.end)
                                            top.linkTo(parent.top)
                                        }
                                ) {
                                    TitleMedium(
                                        text = stateDetail?.get(0)!!.title,
                                        theme = theme,
                                        dimens = dimens,
                                        color = theme.inflect,
                                        size = dimens.dimen_2_25,
                                        font = openSansMedium,
                                        modifier = Modifier
                                            .constrainAs(titleMovie) {
                                                top.linkTo(parent.top)
                                                start.linkTo(parent.start)
                                                end.linkTo(parent.end)
                                            }
                                    )
                                    TitleMedium(
                                        text = stateDetail.get(0)!!.type,
                                        theme = theme,
                                        dimens = dimens,
                                        color = theme.descriptionFilmColor,
                                        size = dimens.dimen_1_5.toFloat(),
                                        modifier = Modifier
                                            .constrainAs(info) {
                                                top.linkTo(
                                                    titleMovie.bottom,
                                                    dimens.dimen_0_25.dp
                                                )
                                                start.linkTo(parent.start)
                                                end.linkTo(parent.end)
                                            }
                                    )
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .constrainAs(columnInfo) {
                                                top.linkTo(
                                                    info.bottom,
                                                    dimens.dimen_1_5.dp
                                                )
                                                start.linkTo(parent.start)
                                                end.linkTo(parent.end)
                                            },
                                        verticalArrangement = Arrangement
                                            .spacedBy(
                                                dimens.dimen_2.dp
                                            ),
                                        horizontalAlignment = Alignment
                                            .CenterHorizontally
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            horizontalArrangement = Arrangement.Center,
                                        ) {
                                            CardMovieInfoSecondary(
                                                theme = theme,
                                                dimens = dimens,
                                                text = stateDetail.get(0)?.date!!
                                            )
                                            SpacerHorizontal4(
                                                dimens = dimens
                                            )
                                            CardMovieInfoSecondary(
                                                theme = theme,
                                                dimens = dimens,
                                                text = stateDetail.get(0)!!.language
                                            )
                                            SpacerHorizontal4(
                                                dimens = dimens
                                            )
                                            CardMovieInfoSecondary(
                                                theme = theme,
                                                dimens = dimens,
                                                text = "${stateDetail.get(0)!!.hours}h ${
                                                    stateDetail.get(
                                                        0
                                                    )!!.minute
                                                }m"
                                            )
                                        }
                                        RatingBar(
                                            dimens = dimens,
                                            theme = theme,
                                            rating = (stateDetail.get(0)!!.vote / 2).toFloat()
                                        )
                                    }
                                    TitleMedium(
                                        text = stateDetail.get(0)!!.description,
                                        theme = theme,
                                        dimens = dimens,
                                        color = theme.descriptionFilmColor,
                                        size = dimens.dimen_1_75,
                                        numOfLine = false,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .constrainAs(description) {
                                                start.linkTo(parent.start)
                                                end.linkTo(parent.end)
                                                top.linkTo(columnInfo.bottom)
                                            }
                                            .padding(dimens.dimen_2.dp)
                                    )
                                    TitleCategory(
                                        dimens = dimens,
                                        theme = theme,
                                        text = "Cast",
                                        size = dimens.dimen_2_5,
                                        modifier = Modifier
                                            .constrainAs(titleCast) {
                                                start.linkTo(
                                                    parent.start,
                                                    dimens.dimen_2_5.dp
                                                )
                                                top.linkTo(
                                                    description.bottom,
                                                    dimens.dimen_2.dp
                                                )
                                            }
                                    )
                                }
                                if (stateCast?.loadState?.refresh is LoadState.NotLoading) {
                                    LazyRow(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .constrainAs(personCast) {
                                                start.linkTo(parent.start)
                                                end.linkTo(parent.end)
                                                top.linkTo(constrainItems.bottom)
                                            },
                                        contentPadding = PaddingValues(
                                            vertical = dimens.dimen_1_5.dp,
                                            horizontal = dimens.dimen_2_5.dp
                                        ),
                                        horizontalArrangement = Arrangement.spacedBy(
                                            dimens.dimen_2_5.dp
                                        )
                                    ) {

                                        items(stateCast!!.itemCount) {
                                            CastItem(
                                                dimens = dimens,
                                                theme = theme,
                                                movieCast = stateCast.get(it)!!
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else -> {}
                }
            }
        }
    }
}
