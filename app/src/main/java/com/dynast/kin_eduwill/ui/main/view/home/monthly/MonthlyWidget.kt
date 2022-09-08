package com.dynast.kin_eduwill.ui.main.view.home.monthly

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme

@Composable
fun MonthlyWidget(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = stringResource(id = R.string.monthly), fontSize = 16.sp, modifier = Modifier.padding(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            MonthlyCardWidget(name = "땅보기좋은날", selection = 7239, answer = 38016, color = Color(0xffB5623A), image = R.drawable.dummy) {

            }
            MonthlyCardWidget(name = "노량진사람", selection = 7239, answer = 38016, color = Color(0xff0058D5), image = R.drawable.dummy) {

            }
            MonthlyCardWidget(name = "기사_준", selection = 7239, answer = 38016, color = Color(0xffFEA514), image = R.drawable.dummy) {

            }
        }
    }
}

@Preview
@Composable
fun MonthlyWidgetPreview() {
    Kin_eduwillTheme {
        MonthlyWidget()
    }
}