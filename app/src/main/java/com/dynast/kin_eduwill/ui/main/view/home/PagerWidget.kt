package com.dynast.kin_eduwill.ui.main.view.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabPosition
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dynast.kin_eduwill.ui.components.CardWidget
import com.dynast.kin_eduwill.ui.main.view.home.items.ProcessStyleItems
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
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
    val pagerState = rememberPagerState(initialPage = 0)

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
                pagerState.animateScrollToPage(page = index)
            }
        )
    })


    Box {
        HorizontalPager(
            count = Int.MAX_VALUE,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) { index ->
            val page = index.floorMod(pagerList.size)
            CardWidget(brush = pagerList[page].brash, onClick = {}) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
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
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
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
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(pagerList.size) {
                if (state.currentPage.floorMod(pagerList.size) == it) {
                    Box(
                        modifier = Modifier
                            .size(width = 8.dp, height = 4.dp)
                            .background(color = Color(0xffFFFFFF), shape = CircleShape)
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(width = 4.dp, height = 4.dp)
                            .background(color = Color(0x33FFFFFF), shape = CircleShape)
                    )
                }
            }
        }
    }
}

fun Modifier.tabIndicatorOffset(
    currentTabPosition: TabPosition
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = currentTabPosition.width,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}

@Preview
@Composable
fun PagerWidgetPreview() {
    Kin_eduwillTheme {
        PagerWidget()
    }
}