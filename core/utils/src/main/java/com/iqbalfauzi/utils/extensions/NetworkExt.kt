package com.iqbalfauzi.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri

/**
 * Created by Iqbal Fauzi on 2/12/21 9:37 PM
 * iqbal.fauzi.if99@gmail.com
 */
fun Activity.connectivityChecker(): Boolean {
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

@Suppress("DEPRECATION")
fun Context.openWebPage(url: String): Boolean {
    // Format the URI properly.
    val uri = url.toWebUri()
    // Try using Chrome Custom Tabs.
    try {
        val intent = CustomTabsIntent.Builder()
            .setToolbarColor(getColorCompat(R.color.purple_500))
            .setShowTitle(true)
            .build()
        intent.launchUrl(this, uri)
        return true
    } catch (ignored: Exception) {
        ignored.printStackTrace()
//        AppLogger.e(ignored.localizedMessage)
    }

    // Fall back to launching a default web browser intent.
    try {
        val intent = Intent(Intent.ACTION_VIEW, uri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
            return true
        }
    } catch (ignored: Exception) {
        ignored.printStackTrace()
    }

    // We were unable to show the web page.
    return false
}

fun String.toWebUri(): Uri {
    return (if (startsWith("http://") || startsWith("https://")) this else "https://$this").toUri()
}