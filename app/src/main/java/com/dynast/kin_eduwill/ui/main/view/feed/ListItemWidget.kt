package com.dynast.kin_eduwill.ui.main.view.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme

@Composable
fun ListItemWidget(
    modifier: Modifier = Modifier,
    item: Any,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick() }
            .then(modifier)
    ) {
        Row {
            Text(text = "shc*****", fontSize = 13.sp, color = Color.Black, lineHeight = 13.sp)
            Text(text = " · ", color = Color(0xff70707A))
            Text(text = "2시간 전", fontSize = 13.sp, color = Color(0xff70707A), lineHeight = 13.sp)
            Text(text = " · ", color = Color(0xff70707A))
            Text(text = "내공 500", fontSize = 13.sp, color = Color(0xff4B9F47), lineHeight = 13.sp)
        }
        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = "한 줄 말줄임 제목 노출", color = Color.Black, fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "안녕하세요 12월부터 공인중개사 시험준비를 계획하고 있읍니다. 그동안 지식인 또는 SNS 후기등으로 …",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = Color(0xff70707A),
            fontSize = 15.sp,
            lineHeight = 22.sp
        )
        Row(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "공무원 > 일반질문 > 9급", color = Color(0xff70707A), fontSize = 13.sp)
            Text(text = "답변 3", color = Color(0xff70707A), fontSize = 13.sp)
        }

//        Divider(
//            modifier = Modifier.padding(vertical = 24.dp),
//            color = Color(red = 241, green = 242, blue = 249)
//        )
    }
}

@Preview
@Composable
fun ListItemWidgetPreview() {
    Kin_eduwillTheme {
        ListItemWidget(item = 1) {

        }
    }
}