package com.dynast.kin_eduwill.ui.main.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.contentColorFor
import androidx.compose.material3.Badge
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.main.view.home.items.BottomItems

val items = listOf(BottomItems.Home, BottomItems.Feed, BottomItems.Notification, BottomItems.Settings)

@Composable
fun NavBar(
    navController: NavController,
    items: List<BottomItems>,
    count: State<Int>,
    onClick: (BottomItems) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.ic_notification_bell),
    )
    val badge = remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = Unit) {
        if (count.value > 0) badge.value = true
    }

    Surface(
        color = Color.White,
        contentColor = contentColorFor(Color.Black),
        elevation = 8.dp,
        modifier = Modifier,
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = {
                items.forEach { item ->
                    val selected = currentRoute == item.route
                    BottomNavigationItem(
                        selected = selected,
                        onClick = {
                            if (item == BottomItems.Notification) {
                                badge.value = false
                            }
                            onClick(item)
                        },
                        icon = {
                            if (item == BottomItems.Notification) {
                                Box(modifier = Modifier.wrapContentSize()) {
                                    if (badge.value) {
                                        LottieAnimation(
                                            modifier = Modifier,
                                            composition = composition,
                                            iterations = LottieConstants.IterateForever,
                                            contentScale = ContentScale.FillBounds,
                                        )
                                        Badge(modifier = Modifier.padding(start = 12.dp)) { Text(text = "${count.value}") }
                                    } else {
                                        Image(painter = painterResource(id = if (selected) item.selected else item.image), contentDescription = item.title)
                                    }
                                }
                            } else {
                                Icon(painter = painterResource(id = if (selected) item.selected else item.image), contentDescription = item.title)
                            }
                        }
                    )
                }
            }
        )
    }
}