package com.dynast.kin_eduwill.ui.launcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor() : ViewModel() {

    var isHome = MutableStateFlow(false)

    init {
        fetchGoHome()
    }

    private fun fetchGoHome() = viewModelScope.launch {
        delay(1000L)
        isHome.emit(true)
    }
}