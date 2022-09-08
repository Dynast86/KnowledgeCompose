package com.dynast.kin_eduwill.ui.launcher

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.dynast.kin_eduwill.ui.main.MainActivity
import com.dynast.kin_eduwill.ui.theme.Kin_eduwillTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LauncherActivity : ComponentActivity() {

    private val viewModel: LauncherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kin_eduwillTheme {
                val isHome by viewModel.isHome.collectAsState()
                LauncherContent()
                if (isHome) {
                    startActivity(Intent(this, MainActivity::class.java)).run { finish() }
                }
            }
        }
    }
}