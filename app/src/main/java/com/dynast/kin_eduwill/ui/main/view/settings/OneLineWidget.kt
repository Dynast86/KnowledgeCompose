package com.dynast.kin_eduwill.ui.main.view.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun OneLineWidget(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    trailing: @Composable (() -> Unit)? = null,
    onClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .clickable { onClick() }
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = title),
                color = Color(0xff11111B),
                fontWeight = FontWeight.Bold
            )
            if (trailing != null)
                trailing()
        }

        Divider(
            modifier = modifier.padding(horizontal = 24.dp),
            color = Color(red = 241, green = 242, blue = 249)
        )
    }
}