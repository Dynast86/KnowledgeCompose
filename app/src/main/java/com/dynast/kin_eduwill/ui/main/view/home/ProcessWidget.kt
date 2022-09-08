package com.dynast.kin_eduwill.ui.main.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.main.view.home.items.ProcessItems
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme

val shape = RoundedCornerShape(topStart = 16.dp, topEnd = 32.dp, bottomStart = 16.dp, bottomEnd = 16.dp)

@Composable
fun RowScope.ProcessWidget(
    modifier: Modifier = Modifier,
    item: ProcessItems,
    onClick: ProcessItems.() -> Unit
) {
    Box(modifier = modifier
        .weight(1f)
        .clip(shape = RoundedCornerShape(16.dp))
        .clickable { item.onClick() }
        .padding(8.dp)) {
        Surface(
            elevation = 6.dp,
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .matchParentSize(),
            shape = shape,
            color = Color.Transparent
        ) {
            Box(
                modifier = modifier.background(brush = item.brash, shape = shape)
            )
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, top = 4.dp), verticalArrangement = Arrangement.SpaceAround) {
            Image(
                painter = painterResource(id = item.image), contentDescription = stringResource(id = item.title),
                modifier = Modifier.size(64.dp)
            )
            Text(
                modifier = Modifier.padding(top = 2.dp, start = 8.dp),
                text = stringResource(id = item.title),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier.padding(top = 4.dp, start = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.send), fontSize = 12.sp,
                    color = Color.White,
                    lineHeight = 18.sp,
                )
                Image(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(12.dp),
                    painter = painterResource(id = R.drawable.ic_chevron), contentDescription = stringResource(id = R.string.send),
                    contentScale = ContentScale.None
                )
            }

        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 480
)
@Composable
fun ProcessWidgetPreview() {
    Kin_eduwillTheme {
        Row {
            ProcessWidget(item = ProcessItems.Kar, onClick = {})
        }
    }
}