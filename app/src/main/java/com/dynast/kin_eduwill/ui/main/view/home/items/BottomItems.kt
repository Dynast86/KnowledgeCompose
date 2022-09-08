package com.dynast.kin_eduwill.ui.main.view.home.items

import androidx.annotation.DrawableRes
import com.dynast.kin_eduwill.R

sealed class BottomItems(
    @DrawableRes val image: Int,
    @DrawableRes val selected: Int,
    val title: String, val route: String
) {
    object Home : BottomItems(image = R.drawable.ic_home_normal, selected = R.drawable.ic_home_selected, "홈", "Home")
    object Feed : BottomItems(image = R.drawable.ic_reader_normal, selected = R.drawable.ic_reader_selected, "새글피드", "Feed")
    object Notification : BottomItems(image = R.drawable.ic_notification_normal, selected = R.drawable.ic_notification_selected, "알림", "Notification")
    object Settings : BottomItems(image = R.drawable.ic_setting_normal, selected = R.drawable.ic_setting_selected, "설정", "Settings")
}
