package com.dynast.kin_eduwill.ui.main.view.home.items

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.dynast.kin_eduwill.R

sealed class ProcessItems(
    @DrawableRes val image: Int,
    val brash: Brush,
    @StringRes val title: Int,
    val primaryColor: Long,
    @DrawableRes val icon: Int
) {
    object Kar : ProcessItems(
        image = R.drawable.img_home_kar, brash = Brush.linearGradient(
            0.0f to Color(0xffCA7646),
            0.5f to Color(0xffB5623A),
            1.0f to Color(0xffA55431),
        ), title = R.string.kar,
        primaryColor = 0xffB5623A,
        icon = R.drawable.ic_kar
    )

    object Official : ProcessItems(
        image = R.drawable.img_home_official, brash = Brush.linearGradient(
            0.0f to Color(0xff006AE1),
            0.5f to Color(0xff0058D5),
            1.0f to Color(0xff004BCB),
        ), title = R.string.official,
        primaryColor = 0xff0058D5,
        icon = R.drawable.ic_official
    )

    object Engineer : ProcessItems(
        image = R.drawable.img_home_engineer, brash = Brush.linearGradient(
            0.0f to Color(0xffFEC41B),
            0.5f to Color(0xffFEB217),
            1.0f to Color(0xffFEA514),
        ), title = R.string.engineer,
        primaryColor = 0xffFEA514,
        icon = R.drawable.ic_engineer
    )
}
