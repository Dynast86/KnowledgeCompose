package com.dynast.kin_eduwill.ui.main.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.ui.components.CardWidget
import com.dynast.kin_eduwill.ui.main.view.home.items.ProcessStyleItems
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay


private val pagerList = listOf(
    ProcessStyleItems.Kar,
    ProcessStyleItems.Official,
    ProcessStyleItems.Engineer,
    ProcessStyleItems.Default
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerWidget(
    modifier: Modifier = Modifier
) {
    val startIndex = Int.MAX_VALUE / 2
    val pagerState = rememberPagerState(initialPage = startIndex)

    LaunchedEffect(pagerState) {
        // Collect from the pager state a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect {
//            AnalyticsService.sendPageSelectedEvent(page)
//            println("page : $it")
        }
    }

    LaunchedEffect(key1 = pagerState, block = {
        repeat(
            times = Int.MAX_VALUE,
            action = { index ->
                delay(timeMillis = 4000)
                val page = (index - startIndex).floorMod(pagerList.size)
                pagerState.animateScrollToPage(page = page)
            }
        )
    })


    Box {
        HorizontalPager(
            count = Int.MAX_VALUE,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) { index ->
            val page = (index - startIndex).floorMod(pagerList.size)
            CardWidget(brush = pagerList[page].brash, onClick = {}) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    Text(
                        text = pagerList[page].title, fontSize = 12.sp, lineHeight = 18.sp,
                        color = if (pagerList[page] == ProcessStyleItems.Default) {
                            Color.Black
                        } else {
                            Color.White
                        }
                    )
                    Text(
                        text = pagerList[page].content, fontSize = 18.sp, lineHeight = 27.sp, fontWeight = FontWeight.Bold,
                        color = if (pagerList[page] == ProcessStyleItems.Default) {
                            Color.Black
                        } else {
                            Color.White
                        }
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .background(
                                shape = RoundedCornerShape(30.dp), color = if (pagerList[page] == ProcessStyleItems.Default) {
                                    Color(0xffFDC300)
                                } else {
                                    Color(0xCCFFFFFF)
                                }
                            )
                    ) {
                        Text(
                            text = stringResource(id = pagerList[page].type), fontSize = 10.sp, fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
                        )
                    }
                }
            }
        }
        Indicators(modifier = modifier.align(Alignment.BottomEnd), state = pagerState)
    }
}

private fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Indicators(
    modifier: Modifier = Modifier,
    state: PagerState
) {
    Box(
        modifier = modifier
            .wrapContentHeight()
            .padding(PaddingValues(bottom = 24.dp, end = 48.dp))
    ) {
        HorizontalPagerIndicator(
            pagerState = state,
            indicatorWidth = 4.dp,
            activeColor = Color.White,
            inactiveColor = Color(0x33FFFFFF),
            pageCount = pagerList.size
        )
    }
}

@Preview
@Composable
fun PagerWidgetPreview() {
    Kin_eduwillTheme {
        PagerWidget()
    }
}