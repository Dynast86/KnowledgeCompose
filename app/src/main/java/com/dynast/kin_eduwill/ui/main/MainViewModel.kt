package com.dynast.kin_eduwill.ui.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.dynast.kin_eduwill.ui.main.view.home.items.ProcessItems
import com.dynast.kin_eduwill.ui.main.view.notification.items.NotificationItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel() {

    var notificationState = mutableStateListOf<NotificationItems>()
        private set

    private var _count = MutableStateFlow(0)
    val count: StateFlow<Int> get() = _count

    init {
        setNotificationData()
        getNotifyUnReadCount()
    }

    private fun setNotificationData() {
        notificationState = mutableStateListOf(
            NotificationItems(id = 0, type = ProcessItems.Kar, title = "메시지 1타이틀", content = "메시지 내용 1열"),
            NotificationItems(id = 1, type = ProcessItems.Official, title = "메시지 2타이틀", content = "메시지 내용 1열", isRead = true),
            NotificationItems(id = 2, type = ProcessItems.Engineer, title = "메시지 3타이틀", content = "메시지 내용 1열")
        )
    }

    fun notifyUpdate(item: NotificationItems) {
        val index = notificationState.indexOf(item)
        notificationState[index] = item.copy(isRead = true)
        getNotifyUnReadCount()
    }

    fun notifyRemove(item: NotificationItems) {
        notificationState.remove(item)
        getNotifyUnReadCount()
    }

    fun notifyRemoveReadOnly() {
        notificationState.removeIf { it.isRead }
        getNotifyUnReadCount()
    }

    fun notifyRemoveAll() {
//        notificationState.removeRange(0, notificationState.size)
        notificationState.clear()
        getNotifyUnReadCount()
    }

    private fun getNotifyUnReadCount() {
        _count.tryEmit(notificationState.filter { !it.isRead }.size)
    }
}