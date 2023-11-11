package com.lomu.uielement.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.lomu.uielement.R
import com.lomu.uielement.theme.mode.CustomColors

val onLightMode = CustomColors(
    background = White,
    systemUi = White,
    red = RedLight,
    colorItemNav = Color.Gray,
    bottomBackground = White,
    itemSelected = RedLight,
    backgroundHome = filmBackgroundLight,
    inflect = Color.Black,
    gold = Gold,
    infCardColor = infCardColorLight,
    white = White,
    starCard = starCard,
    gray = GrayLight,
    redIcon = RedLight,
    infMovie = movieInfoLight,
    descriptionFilmColor = descriptionLight,
    green = greenLight,
    placeholder = R.drawable.place_light
)

val onDarkMode = CustomColors(
    background = Black,
    systemUi = Black,
    red = RedLight,
    colorItemNav = Color.LightGray,
    bottomBackground = Gray,
    itemSelected = RedLight,
    backgroundHome = filmBackgroundDark,
    inflect = Color.White,
    gold = Gold,
    infCardColor = infCardColorDark,
    white = White,
    starCard = starCard,
    gray = GrayDark,
    redIcon = RedLight,
    infMovie = movieInfoDark,
    descriptionFilmColor = GrayDark,
    green = greenDark,
    placeholder = R.drawable.place_dark
)

@Composable
fun netflixTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
): CustomColors {
    return when (darkTheme) {
        true -> onDarkMode
        false -> onLightMode
    }
}