package com.lomu.uielement.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.lomu.uielement.theme.dimen.CustomDimens

val smallDimensions = CustomDimens(
    dimen_0_125 = .75f,
    dimen_0_25 = 1.5f,
    dimen_0_5 = 3,
    dimen_1 = 6,
    dimen_1_5 = 9,
    dimen_2 = 12,
    dimen_2_5 = 15,
    dimen_3 = 18,
    dimen_3_5 = 21,
    dimen_4 = 24,
    dimen_4_5 = 27,
    dimen_5 = 30,
    dimen_5_5 = 33,
    dimen_6 = 36,
    dimen_6_5 = 39,
    dimen_7 = 42,
    dimen_9 = 54,
    dimen_7_25 = 43.5F,
    dimen_43_75 = 262.5F,
    dimen_17_5 = 105F,
    dimen_16 = 96F,
    dimen_1_75 = 10.5F,
    dimen_2_25 = 13.5F,
    dimen_12 = 72F
)

val sw360Dimensions = CustomDimens(
    dimen_0_125 = 1f,
    dimen_0_25 = 2f,
    dimen_0_5 = 4,
    dimen_1 = 8,
    dimen_1_5 = 12,
    dimen_2 = 16,
    dimen_2_5 = 20,
    dimen_3 = 24,
    dimen_3_5 = 28,
    dimen_4 = 32,
    dimen_4_5 = 36,
    dimen_5 = 40,
    dimen_5_5 = 44,
    dimen_6 = 48,
    dimen_6_5 = 52,
    dimen_7 = 56,
    dimen_9 = 72,
    dimen_7_25 = 58F,
    dimen_43_75 = 350F,
    dimen_17_5 = 140F,
    dimen_16 = 128F,
    dimen_1_75 = 14F,
    dimen_2_25 = 18F,
    dimen_12 = 96F
)

@Composable
fun netflixDimens(): CustomDimens {
    val configuration = LocalConfiguration.current
    return if (configuration.screenWidthDp < 360) {
        smallDimensions
    } else {
        sw360Dimensions
    }
}