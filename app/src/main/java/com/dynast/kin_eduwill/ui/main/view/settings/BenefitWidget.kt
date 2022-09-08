package com.dynast.kin_eduwill.ui.main.view.settings

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.main.view.settings.items.SettingsNotificationItems
import com.dynast.kin_eduwill.ui.main.view.switchColor

@Composable
fun BenefitWidget(
    modifier: Modifier = Modifier,
    visible: Boolean = false
) {
    val currentState = remember { MutableTransitionState(visible) }
    val onSwitchedChange: (Boolean) -> Unit = { currentState.targetState = it }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .toggleable(
                    value = currentState.targetState,
                    onValueChange = onSwitchedChange
                )
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${stringResource(id = R.string.benefits)} ${stringResource(id = R.string.notification)}",
                color = Color(0xff11111B),
                fontWeight = FontWeight.Bold
            )
            Switch(
                checked = currentState.targetState, onCheckedChange = null,
                colors = switchColor()
            )
        }
        val items = listOf(
            SettingsNotificationItems(title = stringResource(id = R.string.kar), isChecked = false),
            SettingsNotificationItems(title = stringResource(id = R.string.official), isChecked = false),
            SettingsNotificationItems(title = stringResource(id = R.string.engineer), isChecked = false),
        )
        ExpandableContent(currentState = currentState, items = items)
        Divider(
            modifier = modifier.padding(horizontal = 24.dp),
            color = Color(red = 241, green = 242, blue = 249)
        )
    }
}