package com.lomu.uielement.element.lazyItem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.lomu.model.MovieSearch
import com.lomu.uielement.element.composable.CustomProgress
import com.lomu.uielement.element.modifier.shadow
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.element.composable.*

@Composable
fun FilmSearchItem(
    dimens: CustomDimens,
    theme: CustomColors,
    movie: MovieSearch,
    onClick : (String) -> Unit
) {

    Card(
        modifier = Modifier
            .aspectRatio(.65f)
            .shadow(
                theme = theme,
                dimens = dimens,
                shape = RoundedCornerShape(
                    dimens.dimen_1_5.dp
                ),
                elevation = dimens.dimen_0_25
            )
            .clip(
                RoundedCornerShape(
                    dimens.dimen_1_5.dp
                )
            )
            .clickable { onClick(movie.id) }
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (button, infoBox) = createRefs()
            val guideLineTop70P = GuideLineTop75P()
            val painter = rememberAsyncImagePainter(
                model = ImageRequest
                    .Builder(
                        LocalContext.current
                    ).data(
                        movie.image
                    ).size(
                        coil.size.Size.ORIGINAL
                    ).build()
            )
            val state = painter.state

            if(state is AsyncImagePainter.State.Loading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(theme.infMovie),
                    contentAlignment = Alignment.Center
                ) {
                    CustomProgress(
                        theme = theme,
                        dimen = dimens,
                        size = dimens.dimen_5
                    )
                }
            }

            if(state is AsyncImagePainter.State.Success) {
                HomeImage(
                    src = painter,
                    description = "image",
                    modifier = Modifier
                        .constrainAs(button) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                            top.linkTo(parent.top)
                        }
                )
            }
            Column(
                modifier = Modifier
                    .constrainAs(infoBox) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(guideLineTop70P)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
                    .background(
                        color = theme.infCardColor
                    )
                    .padding(
                        dimens.dimen_1.dp
                    ),
                verticalArrangement = Arrangement
                    .spacedBy(
                        dimens.dimen_0_5.dp
                    )
            ) {
                TitleMedium(
                    text = movie.title,
                    dimens = dimens,
                    theme = theme
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment
                        .CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(
                                    dimens.dimen_0_5.dp
                                )
                            )
                            .background(
                                theme.starCard
                            )
                            .padding(
                                vertical = dimens.dimen_0_25.dp,
                                horizontal = dimens.dimen_0_5.dp
                            ),
                        horizontalArrangement = Arrangement
                            .spacedBy(dimens.dimen_0_25.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        StartIcon(theme = theme)
                        TextSmall(
                            text = movie.vote,
                            theme = theme,
                            color = theme.white,
                            dimens = dimens
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(
                                start = dimens.dimen_0_5.dp
                            )
                    ) {

                        TextSmall(
                            text = movie.date,
                            theme = theme,
                            color = theme.gray,
                            dimens = dimens,
                        )
                    }

                    Box(
                        modifier = Modifier
                            .padding(
                                horizontal = dimens.dimen_0_25.dp
                            )
                    ) {
                        TextSmall(
                            text = "||",
                            theme = theme,
                            color = theme.gray,
                            dimens = dimens,
                        )
                    }
                    TextSmall(
                        text = movie.language,
                        theme = theme,
                        color = theme.gray,
                        dimens = dimens,
                    )
                }
            }
        }
    }
}