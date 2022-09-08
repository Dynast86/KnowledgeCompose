package com.dynast.kin_eduwill.ui.main.view.notification.items

import com.dynast.kin_eduwill.ui.main.view.home.items.ProcessItems
import java.time.LocalDateTime

data class NotificationItems(
    val id: Int,
    val type: ProcessItems,
    val title: String,
    val content: String,
    val time: LocalDateTime? = null,
    var isRead: Boolean = false
)