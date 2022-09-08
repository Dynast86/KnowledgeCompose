package com.dynast.kin_eduwill.ui.main.view.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.ui.main.view.home.items.ProcessItems
import com.dynast.kin_eduwill.ui.main.view.notification.items.NotificationItems
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme


private val shape = RoundedCornerShape(16.dp)

@Composable
fun NotificationItemWidget(
    modifier: Modifier = Modifier,
    item: NotificationItems,
    onClick: (NotificationItems) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .then(modifier)
            .then(
                if (item.isRead) {
                    Modifier
                        .border(width = 1.dp, shape = shape, color = Color(0xffF1F2FA))
                        .background(color = Color.White, shape = shape)
                } else {
                    Modifier.background(shape = shape, color = Color(0xffEFF8FF))
                }
            )
            .clip(shape = shape)
            .clickable { onClick(item) }
            .padding(16.dp)
    ) {
        Row {
            Image(painter = painterResource(id = item.type.icon), contentDescription = null)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(text = stringResource(id = item.type.title), color = Color(0xff70707A), fontSize = 11.sp)
                Text(modifier = Modifier.padding(top = 4.dp), text = item.title, fontSize = 13.sp)
                Text(modifier = Modifier.padding(top = 4.dp), text = item.content, fontSize = 13.sp)
            }
            Text(text = "44분 전", color = Color(0xff2673F0), fontSize = 11.sp)
        }
    }
}

@Preview
@Composable
fun NotificationItemWidgetPreview() {
    Kin_eduwillTheme {
        NotificationItemWidget(
            modifier = Modifier.padding(horizontal = 24.dp),
            item = NotificationItems(id = 0, type = ProcessItems.Kar, title = "메시지 1타이틀", content = "메시지 내용 1열")
        ) {

        }
    }
}