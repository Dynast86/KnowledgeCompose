package com.dynast.kin_eduwill.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dynast.kin_eduwill.R
import com.dynast.kin_eduwill.ui.main.view.home.items.BottomItems
import com.dynast.kin_eduwill.ui.theme.EduwillFont

@Composable
fun KinTopBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White)
            .padding(end = 8.dp),
    ) {
        when (currentRoute) {
            BottomItems.Feed.route -> {
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.news_feed),
                    fontSize = 18.sp, fontWeight = FontWeight.Bold
                )
            }
            BottomItems.Notification.route -> {
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.notification),
                    fontSize = 18.sp, fontWeight = FontWeight.Bold
                )
            }
            BottomItems.Settings.route -> {
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = stringResource(id = R.string.settings),
                    fontSize = 18.sp, fontWeight = FontWeight.Bold
                )
            }
            else -> {
                var searchState by remember { mutableStateOf(false) }
                var backState by remember { mutableStateOf(false) }
                if (searchState) {
                    backState = true
                    TextFieldWidget(modifier.weight(1f), hint = R.string.hint_search_text) {
                        searchState = false
                    }
                } else {
                    backState = false
                    Image(
                        modifier = Modifier.padding(start = 20.dp, end = 4.dp),
                        painter = painterResource(id = R.drawable.ic_logo), contentDescription = "Logo"
                    )
                    Text(text = "에듀윌", fontWeight = FontWeight.Bold, fontSize = 20.sp, fontFamily = EduwillFont)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        color = Color(0xff2673F0),
                        text = "지식인", modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold, fontSize = 20.sp, fontFamily = EduwillFont
                    )
                    if (currentRoute == BottomItems.Home.route) {
                        IconButton(
                            onClick = { searchState = true }) {
                            Image(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search")
                        }
                    }
                }

                BackHandler(enabled = backState) {
                    if (searchState) {
                        searchState = false
                    }
                }
            }
        }
    }
}