package com.dynast.kin_eduwill.ui.main.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.kin_eduwill.ui.main.view.home.PagerWidget
import com.dynast.kin_eduwill.ui.main.view.home.ProcessWidget
import com.dynast.kin_eduwill.ui.main.view.home.event.EventWidget
import com.dynast.kin_eduwill.ui.main.view.home.items.ProcessItems
import com.dynast.kin_eduwill.ui.main.view.home.monthly.MonthlyWidget
import com.dynast.kin_eduwill.ui.main.view.home.tip.TipWidget
import com.dynast.kin_eduwill.ui.startWebView
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme

@Composable
fun HomeContent() {
    val context = LocalContext.current

    LazyColumn(modifier = Modifier) {
        item {
            Row(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(paddingValues = PaddingValues(horizontal = 16.dp)),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProcessWidget(item = ProcessItems.Kar, onClick = {
                    context.startWebView("https://www.google.com")
                })
                ProcessWidget(item = ProcessItems.Official, onClick = {
                    context.startWebView("https://www.google.com")
                })
                ProcessWidget(item = ProcessItems.Engineer, onClick = {
                    context.startWebView("https://www.google.com")
                })
            }
        }
        item { PagerWidget() }
        item { Spacer(modifier = Modifier.size(8.dp)) }
        item {
            TipWidget(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(paddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp))
            )
        }
        item {
            MonthlyWidget(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(paddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp))
            )
        }
        item {
            EventWidget(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(paddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp))
            )
        }
    }
}


@Preview(
    showBackground = true,
    widthDp = 1024
)
@Composable
fun HomeContentPreview() {
    Kin_eduwillTheme {
        HomeContent()
    }
}