package com.dynast.kin_eduwill.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dynast.kin_eduwill.ui.main.nav.NavBar
import com.dynast.kin_eduwill.ui.main.nav.NavGraph
import com.dynast.kin_eduwill.ui.main.nav.items
import com.dynast.kin_eduwill.ui.main.view.home.items.BottomItems

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val count = viewModel.count.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = if (currentRoute == BottomItems.Home.route) {
                    Brush.verticalGradient(
                        0.0f to Color(0xffFFFFFF),
                        1.0f to Color(0xffF2F6FF)
                    )
                } else {
                    Brush.verticalGradient(
                        0.0f to Color(0xffFFFFFF),
                        1.0f to Color(0xffFFFFFF)
                    )
                }
            )
            .then(modifier)
    ) {
        Column(modifier = modifier.fillMaxSize()) {
            NavGraph(
                modifier = modifier.weight(1f),
                navController = navController,
                startDestination = BottomItems.Home.route,
                viewModel = viewModel
            )
            NavBar(navController = navController, items = items, count = count) {
                navController.navigation(it)
            }
        }
    }
}

fun NavController.navigation(item: BottomItems) {
    navigate(item.route) {
        graph.startDestinationRoute?.let { screen_route ->
            popUpTo(screen_route) { saveState = true }
        }
        launchSingleTop = true
        restoreState = true
    }
}
