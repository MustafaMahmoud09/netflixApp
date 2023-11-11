package com.lomu.uielement.element.lazyItem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.lomu.model.MovieCast
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.theme.openSansMedium
import com.lomu.uielement.element.composable.*
import com.lomu.uielement.R

@Composable
fun CastItem(
    dimens: CustomDimens,
    theme: CustomColors,
    modifier: Modifier = Modifier,
    movieCast: MovieCast
) {
    Column(
        modifier = modifier
            .wrapContentSize(),
        verticalArrangement = Arrangement
            .spacedBy(dimens.dimen_0_25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .size(dimens.dimen_12.dp)
                .clip(CircleShape)
        ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest
                    .Builder(
                        LocalContext.current
                    ).data(
                        movieCast.image
                    ).size(
                        coil.size.Size.ORIGINAL
                    ).build()
            )
            val state = painter.state

            if (state is AsyncImagePainter.State.Loading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(theme.infMovie),
                    contentAlignment = Alignment.Center
                ) {
                    CustomProgress(
                        theme = theme,
                        dimen = dimens,
                        size = dimens.dimen_3
                    )
                }
            }

            if(state is AsyncImagePainter.State.Error){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(theme.inflect),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_baseline_person_24
                        ),
                        contentDescription = "empty",
                        tint = theme.redIcon,
                        modifier = Modifier
                            .size(dimens.dimen_6.dp)
                    )
                }
            }
            if (state is AsyncImagePainter.State.Success) {
                HomeImage(
                    src = painter,
                    description = "poster"
                )
            }
        }
        SpacerVertical4(dimens = dimens)
        TitleMedium(
            dimens = dimens,
            theme = theme,
            text = movieCast.title,
            color = theme.inflect,
            size = dimens.dimen_1_75,
            font = openSansMedium
        )
        TextSmall(
            text = movieCast.type,
            theme = theme,
            dimens = dimens,
            color = theme.descriptionFilmColor,
            size = dimens.dimen_1_75
        )
    }
}