package com.dynast.kin_eduwill.ui.main.view.home.tip

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.ui.components.CardWidget

@Composable
fun RowScope.TipCardWidget(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    subTitle: String,
    color: Color,
    @DrawableRes image: Int,
    onClick: () -> Unit,
) {
    CardWidget(
        modifier = modifier
            .weight(1f)
            .height(122.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, bottom = 8.dp, end = 4.dp)
                .fillMaxSize()
        ) {
            Text(text = stringResource(id = title), color = color, fontSize = 12.sp)
            Text(text = subTitle, color = Color(0xff33333D), fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), contentAlignment = Alignment.BottomEnd
            ) {
                Image(painter = painterResource(id = image), contentDescription = stringResource(id = title))
            }
        }
    }
}