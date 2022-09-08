package com.dynast.kin_eduwill.ui.main.view.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R

@Composable
fun LoginWidget(
    isLogin: Boolean,
    modifier: Modifier = Modifier
) {
    val state = remember { mutableStateOf(isLogin) }
    var functionLogoutDialogPopup by remember { mutableStateOf(false) }
    if (functionLogoutDialogPopup) {
        LogoutPopup(onConfirm = {
            state.value = false
            functionLogoutDialogPopup = false
        }) { functionLogoutDialogPopup = false }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = stringResource(id = if (state.value) R.string.login_info else R.string.login),
                    color = Color(0xff11111B),
                    fontWeight = FontWeight.Bold
                )
                if (state.value) Text(text = "eduwill1234", color = Color(0xffAAAAB4), fontSize = 12.sp)
            }
            OutlinedButton(
                onClick = {
                    if (state.value) {
                        functionLogoutDialogPopup = true
                    } else {
                        state.value = !state.value
                    }
                },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = stringResource(if (state.value) R.string.logout else R.string.login),
                    color = Color(0xff70707A),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
        }
        Divider(
            modifier = modifier.padding(horizontal = 24.dp),
            color = Color(red = 241, green = 242, blue = 249)
        )
    }

}