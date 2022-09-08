package com.dynast.kin_eduwill.ui.main.view.notification

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R

enum class ClickType {
    ReadOnly, All
}

@Composable
fun FilterWidget(
    modifier: Modifier = Modifier,
    count: Int = 0,
    onClick: (ClickType) -> Unit
) {
    Row(
        modifier = modifier.padding(top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = R.string.new_notification), fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Text(
            modifier = Modifier.weight(1f),
            text = " ${count}건", color = Color(0xff2673F0), fontWeight = FontWeight.Bold, fontSize = 13.sp
        )

        OutlinedButton(
            modifier = Modifier.padding(start = 4.dp),
            onClick = { onClick(ClickType.ReadOnly) },
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.read_message_delete),
                color = Color(0xff70707A),
                fontSize = 12.sp
            )
        }

        OutlinedButton(
            modifier = Modifier
                .padding(start = 4.dp),
            onClick = { onClick(ClickType.All) },
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(R.string.all_message_delete),
                color = Color(0xff70707A),
                fontSize = 12.sp
            )
        }
    }
}