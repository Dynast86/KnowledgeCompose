package com.dynast.kin_eduwill.ui.main.view.settings

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.ui.main.view.settings.items.SettingsNotificationItems

@Composable
fun ExpandableContent(
    currentState: MutableTransitionState<Boolean>,
    items: List<SettingsNotificationItems>
) {
    AnimatedVisibility(
        visibleState = currentState,
        enter = fadeIn() + expandVertically(),
        exit = fadeOut() + shrinkVertically()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .background(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xffEFF8FF)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                repeat(items.size) { position ->
                    val content = items[position]
                    var checked by remember { mutableStateOf(false) }
                    val onCheckedChange: (Boolean) -> Unit = { checked = it }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .toggleable(
                                value = checked,
                                onValueChange = onCheckedChange
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = "${content.title}", fontSize = 13.sp
                        )
                        CheckBoxWidget(checked = checked, onCheckedChange = onCheckedChange)
                    }
                }
            }
        }
    }
}