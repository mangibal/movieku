package com.iqbalfauzi.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

/**
 * Created by Iqbal Fauzi on 2/12/21 9:40 PM
 * iqbal.fauzi.if99@gmail.com
 */
fun Context.copyText(label: String, text: String) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(label, text)
    clipboard.setPrimaryClip(clip)
}