package com.dynast.kin_eduwill.ui.main.view.home.event

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.components.CardWidget
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme


@Composable
fun RowScope.EventCardWidget(
    modifier: Modifier = Modifier,
    type: EventType = EventType.None,
    @StringRes title: Int,
    @DrawableRes image: Int,
    onClick: () -> Unit
) {
    CardWidget(
        modifier = modifier
            .weight(1f)
            .wrapContentHeight(),
        onClick = onClick
    ) {
        when (type) {
            EventType.Flat -> Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(start = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(text = stringResource(id = title), color = Color(0xff33333D), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(end = 8.dp, bottom = 4.dp, top = 12.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Image(painter = painterResource(id = image), contentDescription = null)
                }
            }
            EventType.None -> Column(
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = image), contentDescription = null)
                Text(text = stringResource(id = title), color = Color(0xff33333D), fontSize = 12.sp, fontWeight = FontWeight.W600)
            }
        }
    }
}


@Preview
@Composable
fun EventCardWidgetPreview() {
    Kin_eduwillTheme {
        Row {
            EventCardWidget(type = EventType.Flat, title = R.string.kar, image = R.drawable.img_random) {

            }
        }
    }
}