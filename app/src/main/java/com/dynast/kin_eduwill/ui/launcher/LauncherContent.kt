package com.dynast.kin_eduwill.ui.launcher

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.theme.EduwillFont
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme

@Composable
fun LauncherContent(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xff2673F0)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 204.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "자격증/공시 준비의 시작",
                fontSize = 18.sp,
                lineHeight = 27.sp,
                color = Color.White,
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "에듀윌 지식인",
                fontSize = 36.sp,
                fontFamily = EduwillFont,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = R.drawable.img_kin_logo), contentDescription = "Logo")
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 72.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier.size(width = 68.dp, height = 28.dp),
                painter = painterResource(id = R.drawable.img_eduwill_logo), contentDescription = "Eduwill Logo"
            )
        }
    }
}

@Preview
@Composable
fun LauncherContentPreview() {
    Kin_eduwillTheme {
        LauncherContent()
    }
}