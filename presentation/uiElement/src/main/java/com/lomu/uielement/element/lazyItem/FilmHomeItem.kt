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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.lomu.model.MovieHome
import com.lomu.uielement.element.composable.HomeImage
import com.lomu.uielement.element.composable.StartIcon
import com.lomu.uielement.element.composable.TextSmall
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.R
import com.lomu.uielement.element.composable.CustomProgress
import com.lomu.uielement.element.modifier.shadow

@Composable
fun FilmHomeItem(
    theme: CustomColors,
    dimens: CustomDimens,
    movieHome: MovieHome,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .width(dimens.dimen_17_5.dp)
            .aspectRatio(0.5F)
            .shadow(
                dimens = dimens,
                theme = theme,
                shape =  RoundedCornerShape(
                    dimens.dimen_2.dp
                ),
                elevation = dimens.dimen_0_5.toFloat()
            )
            .clip(
                RoundedCornerShape(
                    dimens.dimen_2.dp
                )
            )
            .clickable { onClick(movieHome.id) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest
                    .Builder(
                        LocalContext.current
                    ).data(
                        movieHome.image
                    ).size(
                        Size.ORIGINAL
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
            if (state is AsyncImagePainter.State.Success) {
                HomeImage(
                    src = painter,
                    description = "image"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimens.dimen_0_5.dp),
                horizontalArrangement = Arrangement
                    .spacedBy(
                        dimens.dimen_0_5.dp
                    ),
                verticalAlignment = Alignment
                    .CenterVertically
            ) {
                StartIcon(
                    theme = theme
                )
                TextSmall(
                    text = movieHome.rate,
                    theme = theme,
                    dimens = dimens
                )
            }
        }
    }
}