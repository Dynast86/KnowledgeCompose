package com.dynast.kin_eduwill.ui.main.view

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.components.TabWidget
import com.dynast.kin_eduwill.ui.main.MainViewModel
import com.dynast.kin_eduwill.ui.main.view.notification.*
import com.dynast.kin_eduwill.ui.main.view.notification.items.NotificationItems
import com.google.accompanist.pager.ExperimentalPagerApi

private val list = listOf(R.string.my_kin, R.string.benefits)

data class AlertPopup(
    val isPopup: Boolean,
    val type: ClickType = ClickType.All,
)

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun NotificationContent(
    modifier: Modifier = Modifier,
    count: State<Int>,
    viewModel: MainViewModel = hiltViewModel()
) {
    val notifyList = remember { viewModel.notificationState }

    var functionDialogPopup by remember { mutableStateOf(AlertPopup(isPopup = false)) }
    if (functionDialogPopup.isPopup) {
        NotificationPopup(
            title = if (functionDialogPopup.type == ClickType.ReadOnly) R.string.notification_popup_title_readonly else R.string.notification_popup_title_all,
            content = if (functionDialogPopup.type == ClickType.ReadOnly) R.string.notification_popup_subtitle_readonly else R.string.notification_popup_subtitle_all,
            onConfirm = {
                with(viewModel) {
                    if (functionDialogPopup.type == ClickType.ReadOnly) {
                        notifyRemoveReadOnly()
                    } else {
                        notifyRemoveAll()
                    }
                }
                functionDialogPopup = AlertPopup(isPopup = false)
            }) { functionDialogPopup = AlertPopup(isPopup = false) }
    }

    TabWidget(modifier = modifier, list = list) {
        Column {
            FilterWidget(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp), count = count.value
            ) {
                functionDialogPopup = AlertPopup(isPopup = true, type = it)
            }

            if (notifyList.isNotEmpty()) {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(items = notifyList, { list: NotificationItems -> list.id }) { item ->
                        val dismissState = rememberDismissState()
                        if (dismissState.isDismissed(DismissDirection.StartToEnd)) {
                            viewModel.notifyRemove(item)
                        }

                        SwipeToDismiss(
                            state = dismissState,
                            modifier = Modifier.padding(vertical = Dp(1f)),
                            directions = setOf(DismissDirection.StartToEnd),
                            dismissThresholds = { direction -> FractionalThreshold(if (direction == DismissDirection.StartToEnd) 0.2f else 0.05f) },
                            background = {
                                val color by animateColorAsState(
                                    when (dismissState.targetValue) {
                                        DismissValue.Default -> Color.White
                                        else -> Color.Red
                                    }
                                )

                                Box(
                                    Modifier
                                        .padding(horizontal = 24.dp, vertical = 4.dp)
                                        .clip(shape = RoundedCornerShape(16.dp))
                                        .fillMaxSize()
                                        .background(color),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    Image(
                                        modifier = Modifier.padding(start = 24.dp),
                                        painter = painterResource(id = R.drawable.ic_delete), contentDescription = stringResource(id = R.string.delete)
                                    )
                                }
                            }
                        ) {
                            NotificationItemWidget(modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp), item = item) {
                                viewModel.notifyUpdate(item)
                            }
                        }
                    }
                }
            } else {
                EmptyItemWidget()
            }
        }
    }
}