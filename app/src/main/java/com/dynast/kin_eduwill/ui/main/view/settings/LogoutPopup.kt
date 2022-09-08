package com.dynast.kin_eduwill.ui.main.view.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.components.DialogPopup

@Composable
fun LogoutPopup(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    DialogPopup(onDismiss = onDismiss) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .safeContentPadding()
                    .padding(vertical = 4.dp),
                text = stringResource(id = R.string.logout_popup_title),
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp)
            ) {
                Button(
                    modifier = Modifier.weight(1f), onClick = onDismiss, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffF1F2FA)
                    )
                ) {
                    Text(text = stringResource(id = R.string.dismiss), color = Color(0xff70707A))
                }
                Spacer(modifier = Modifier.size(8.dp))
                Button(
                    modifier = Modifier.weight(1f), onClick = onConfirm, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff2673F0)
                    )
                ) {
                    Text(text = stringResource(id = R.string.confirm), color = Color.White)
                }
            }
        }
    }
}