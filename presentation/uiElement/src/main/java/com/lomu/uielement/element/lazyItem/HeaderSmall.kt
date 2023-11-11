package com.lomu.uielement.element.lazyItem

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
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
import com.lomu.uielement.R
import com.lomu.uielement.element.composable.CustomProgress
import com.lomu.uielement.element.composable.HomeImage
import com.lomu.uielement.element.composable.SpacerBackground
import com.lomu.uielement.element.modifier.shadow
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors

@Composable
fun HeaderSmall(
    theme: CustomColors,
    dimen: CustomDimens,
    movie: MovieHome,
    onClick : (String) -> Unit
) {
    Card(
        modifier = Modifier
            .width(dimen.dimen_17_5.dp)
            .aspectRatio(2.3F)
            .shadow(
                dimens = dimen,
                theme = theme,
                shape =  RoundedCornerShape(
                    dimen.dimen_1_5.dp
                ),
                elevation = dimen.dimen_0_5.toFloat()
            )
            .clip(
                RoundedCornerShape(
                    dimen.dimen_1_5.dp
                )
            )
            .animateContentSize(
                animationSpec = tween(600)
            )
            .clickable { onClick(movie.id) }
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest
                .Builder(
                    LocalContext.current
                ).data(
                    movie.image
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
                    dimen = dimen,
                    size = dimen.dimen_3
                )
            }
        }

        if (state is AsyncImagePainter.State.Success) {

            HomeImage(
                src = painter,
                description = "image",
            )
            SpacerBackground(
                color = theme.backgroundHome
            )
        }
    }
}