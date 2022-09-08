package com.dynast.kin_eduwill.ui.main.state

import androidx.compose.runtime.MutableState
import com.dynast.kin_eduwill.ui.main.view.settings.items.SettingsNotificationItems

class SettingsState(
    val answer: MutableState<SettingsNotificationItems>,
    val selection: MutableState<SettingsNotificationItems>,
    val gradeUp: MutableState<SettingsNotificationItems>,
    val comment: MutableState<SettingsNotificationItems>,
)