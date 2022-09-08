package com.dynast.kin_eduwill.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.dynast.kin_eduwill.ui.components.KinTopBar
import com.dynast.kin_eduwill.ui.components.SnackBarWidget
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kin_eduwillTheme {
                val navController = rememberNavController()

                val functionSnackBar by remember { mutableStateOf(false) }

//                LaunchedEffect(key1 = Unit) {
//                    delay(2000L)
//                    functionSnackBar = true
//                }

                Scaffold(
                    topBar = { KinTopBar(navController = navController) }) {
                    MainContent(
                        modifier = Modifier.padding(it),
                        navController = navController,
                        viewModel = viewModel
                    )
                }

                if (functionSnackBar) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        SnackBarWidget {
                            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                                Text(text = "광고성 정보 수신에 동의하셨습니다.", fontSize = 13.sp)
                                Text(text = "2022.08.24", fontSize = 13.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}
