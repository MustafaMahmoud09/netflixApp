package com.lomu.uielement.element.lazyItem

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.lomu.model.MovieFavorite
import com.lomu.uielement.R
import com.lomu.uielement.element.modifier.shadow
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import com.lomu.uielement.element.composable.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyItemScope.MovieFavoriteItem(
    theme: CustomColors,
    dimens: CustomDimens,
    onClick : (String) -> Unit,
    movie: MovieFavorite,
    onClickOnItem:(String) -> Unit
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.55f)
            .shadow(
                theme = theme,
                dimens = dimens,
                shape = RoundedCornerShape(
                    dimens.dimen_1.dp
                ),
                elevation = dimens.dimen_0_5.toFloat()
            )
            .clip(
                RoundedCornerShape(
                    dimens.dimen_1.dp
                )
            )
            .animateItemPlacement()
            .clickable { onClickOnItem(movie.id) }
    ) {
        val (info,menu) = createRefs()
        val guideTop85P = GuideLineTop85P()

        val painter = rememberAsyncImagePainter(
            model = ImageRequest
                .Builder(
                    LocalContext.current
                ).data(
                    movie.path
                ).size(
                    Size.ORIGINAL
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

        if(state is AsyncImagePainter.State.Error){
              Box(
                  modifier = Modifier
                      .fillMaxSize()
                      .background(
                          color = theme.background
                      )
                      .padding(dimens.dimen_4.dp),
                  contentAlignment = Alignment.Center
              ) {
                  Icon(
                      painter = painterResource(
                          id = R.drawable.place_dark
                      ),
                      contentDescription = "",
                      tint = theme.redIcon
                  )
              }
        }

        if(state is AsyncImagePainter.State.Success) {
            HomeImage(
                src = painter,
                description = "favorite image"
            )
        }

        CustomIcon(
            theme = theme,
            dimens = dimens,
            modifier = Modifier
                .constrainAs(menu) {
                    end.linkTo(parent.end, dimens.dimen_2.dp)
                    top.linkTo(parent.top, dimens.dimen_1.dp)
                }
                .clickable { onClick(movie.id) }
        )

        ConstraintLayout(
            modifier = Modifier
                .constrainAs(info) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(guideTop85P)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(
                    color = theme.infCardColor
                )
        ) {
            val (title,rating) = createRefs()
            TitleMedium(
                text = movie.title,
                dimens = dimens,
                theme = theme,
                modifier = Modifier
                    .constrainAs(title){
                        start.linkTo(parent.start,dimens.dimen_1.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )

            RatingBar(
                dimens = dimens,
                theme = theme,
                rating = movie.vote.toFloat()/2,
                modifier = Modifier
                    .constrainAs(rating){
                        end.linkTo(parent.end,dimens.dimen_1.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                size = dimens.dimen_2_5.toFloat()
            )

        }
    }
}