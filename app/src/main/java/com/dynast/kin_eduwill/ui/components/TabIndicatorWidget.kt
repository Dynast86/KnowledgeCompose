package com.dynast.kin_eduwill.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme
import com.dynast.kin_eduwill.ui.theme.coloredShadow

private val shape = RoundedCornerShape(16.dp)

@Composable
fun TabIndicatorWidget(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    @StringRes item: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(4.dp)
            .then(
                if (isSelected) {
                    Modifier
                        .coloredShadow(
                            color = Color(0x2600057B),
                            borderRadius = 16.dp,
                            blur = 8.dp,
                            offsetY = 4.dp
                        )
                        .background(shape = shape, color = Color(0xff2673F0))
                } else {
                    Modifier.background(color = Color.Transparent)
                }
            )
            .clip(shape = shape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(vertical = 6.dp),
            text = stringResource(id = item), fontSize = 13.sp, fontWeight = if (isSelected) {
                FontWeight.W600
            } else {
                FontWeight.W400
            },
            color = if (isSelected) {
                Color.White
            } else {
                Color(0xff70707A)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TabIndicatorWidgetPreview() {
    Kin_eduwillTheme {
        TabIndicatorWidget(isSelected = true, item = R.string.kar) {

        }
    }
}