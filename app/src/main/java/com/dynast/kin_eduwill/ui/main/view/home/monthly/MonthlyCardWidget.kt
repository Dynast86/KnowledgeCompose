package com.dynast.kin_eduwill.ui.main.view.home.monthly

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.components.CardWidget
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme

@Composable
fun RowScope.MonthlyCardWidget(
    modifier: Modifier = Modifier,
    name: String,
    selection: Int,
    answer: Int,
    color: Color,
    @DrawableRes image: Int,
    onClick: () -> Unit,
) {
    CardWidget(
        modifier = modifier
            .weight(1f)
            .wrapContentHeight(),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .requiredWidthIn(max = 52.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp, color = color, shape = CircleShape
                    ),
                painter = painterResource(id = image), contentDescription = "Profile"
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = name,
                color = Color(0xff33333D),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W600
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "채택 $selection", color = Color(0xffAAAAB4), fontSize = 12.sp, textAlign = TextAlign.Center
            )
            Text(
                text = "답변 $answer", color = Color(0xffAAAAB4), fontSize = 12.sp, textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun MonthlyCardWidgetPreview() {
    Kin_eduwillTheme {
        Row {
            MonthlyCardWidget(name = "땅보기좋은날", selection = 7239, answer = 38016, color = Color(0xffB5623A), image = R.drawable.dummy) {

            }
        }
    }
}