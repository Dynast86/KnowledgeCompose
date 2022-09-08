package com.dynast.kin_eduwill.ui.main.nav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dynast.kin_eduwill.ui.main.MainViewModel
import com.dynast.kin_eduwill.ui.main.view.FeedContent
import com.dynast.kin_eduwill.ui.main.view.HomeContent
import com.dynast.kin_eduwill.ui.main.view.NotificationContent
import com.dynast.kin_eduwill.ui.main.view.SettingsContent
import com.dynast.kin_eduwill.ui.main.view.home.items.BottomItems

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    viewModel: MainViewModel = hiltViewModel()
) {
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {
        composable(BottomItems.Home.route) {
            HomeContent()
        }
        composable(BottomItems.Feed.route) {
            FeedContent()
        }
        composable(BottomItems.Notification.route) {
            NotificationContent(
                count = viewModel.count.collectAsState(), viewModel = viewModel
            )
        }
        composable(BottomItems.Settings.route) {
            SettingsContent(modifier = Modifier.fillMaxSize())
        }
    }
}
