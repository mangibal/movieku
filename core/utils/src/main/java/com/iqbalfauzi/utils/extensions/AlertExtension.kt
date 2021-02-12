package com.iqbalfauzi.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by Iqbal Fauzi on 2/12/21 9:52 AM
 * iqbal.fauzi.if99@gmail.com
 */
fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}