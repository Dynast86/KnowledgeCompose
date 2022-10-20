package com.dynast.kin_eduwill.ui

import android.content.Context
import android.content.Intent
import com.dynast.kin_eduwill.ui.webview.WebViewActivity

const val UrlParams = "URL"

fun Context.startWebView(url: String) {
    startActivity(Intent(this, WebViewActivity::class.java).apply {
        putExtra(UrlParams, url)
    })
}