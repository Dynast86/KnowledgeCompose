package com.dynast.kin_eduwill.ui.main.view.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dynast.kin_eduwill.R

@Composable
fun EmptyItemWidget(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.padding(24.dp),
                painter = painterResource(id = R.drawable.ic_notification_empty), contentDescription = "empty"
            )
            Text(
                text = stringResource(id = R.string.notification_empty_list), fontWeight = FontWeight.Bold,
                color = Color(0xff70707A)
            )
        }
    }
}