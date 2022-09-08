package com.dynast.kin_eduwill.ui.main.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dynast.kin_eduwill.ui.components.TabWidget
import com.dynast.kin_eduwill.ui.main.view.feed.ListItemWidget
import com.dynast.kin_eduwill.ui.main.view.home.items.ProcessItems
import com.google.accompanist.pager.ExperimentalPagerApi

private val list = listOf(ProcessItems.Kar, ProcessItems.Official, ProcessItems.Engineer)
private val dummy = listOf(
    0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FeedContent(
    modifier: Modifier = Modifier
) {
    val items: List<Int> = list.map { it.title }
    TabWidget(modifier = modifier, list = items) {
        LazyColumn {
            itemsIndexed(dummy) { index, item ->
                ListItemWidget(modifier = Modifier.padding(24.dp), item = item) {

                }
                if (index < dummy.lastIndex)
                    Divider(
                        modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                        color = Color(red = 241, green = 242, blue = 249), thickness = 1.dp
                    )

            }
        }
    }
}