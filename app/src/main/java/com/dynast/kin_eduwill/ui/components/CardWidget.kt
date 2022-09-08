package com.dynast.kin_eduwill.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dynast.kin_eduwill.ui.theme.coloredShadow

private val shape = RoundedCornerShape(16.dp)

@Composable
fun CardWidget(
    modifier: Modifier = Modifier,
    brush: Brush = Brush.verticalGradient(
        0.0f to Color(0xffFFFFFF),
        1.0f to Color(0xffFFFFFF)
    ),
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .coloredShadow(
                color = Color(0x1A00057B),
                borderRadius = 16.dp,
                blur = 20.dp,
                offsetY = 15.dp
            )
            .background(brush = brush, shape = shape)
            .clip(shape = shape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}