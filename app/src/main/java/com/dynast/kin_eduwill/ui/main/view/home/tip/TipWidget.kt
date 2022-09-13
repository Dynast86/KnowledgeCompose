package com.dynast.kin_eduwill.ui.main.view.home.tip

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme

@Composable
fun TipWidget(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(id = R.string.tip),
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            TipCardWidget(
                title = R.string.kar, subTitle = "용어집",
                image = R.drawable.img_book, color = Color(0xffB5623A)
            ) {

            }
            TipCardWidget(
                title = R.string.official, subTitle = "이슈브리핑",
                image = R.drawable.img_chart, color = Color(0xff0058D5)
            ) {

            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            TipCardWidget(
                title = R.string.kar, subTitle = "유튜브",
                image = R.drawable.img_youtube_kar, color = Color(0xffB5623A)
            ) {

            }
            TipCardWidget(
                title = R.string.official, subTitle = "유튜브",
                image = R.drawable.img_youtube_official, color = Color(0xff0058D5)
            ) {

            }
            TipCardWidget(
                title = R.string.engineer, subTitle = "유튜브",
                image = R.drawable.img_youtube_engineer, color = Color(0xffFEA514)
            ) {

            }
        }
    }
}

@Preview
@Composable
fun TipWidgetPreview() {
    Kin_eduwillTheme {
        TipWidget()
    }
}