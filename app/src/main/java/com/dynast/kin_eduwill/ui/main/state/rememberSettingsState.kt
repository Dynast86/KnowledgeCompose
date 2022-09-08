package com.dynast.kin_eduwill.ui.main.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dynast.kin_eduwill.ui.main.view.settings.items.SettingsNotificationItems

@Composable
fun rememberSettingsState(
    answer: MutableState<SettingsNotificationItems> = remember { mutableStateOf(SettingsNotificationItems(title = "- 답변 알림")) },
    selection: MutableState<SettingsNotificationItems> = remember { mutableStateOf(SettingsNotificationItems(title = "- 채택 알림")) },
    gradeUp: MutableState<SettingsNotificationItems> = remember { mutableStateOf(SettingsNotificationItems(title = "- 등업 알림")) },
    comment: MutableState<SettingsNotificationItems> = remember { mutableStateOf(SettingsNotificationItems(title = "- 댓글 알림")) },
): SettingsState = remember {
    SettingsState(
        answer = answer,
        selection = selection,
        gradeUp = gradeUp,
        comment = comment
    )
}