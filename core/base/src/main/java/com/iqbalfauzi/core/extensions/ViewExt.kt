package com.iqbalfauzi.core.extensions

import android.view.View

/**
 * Created by Iqbal Fauzi on 2/12/21 9:48 PM
 * iqbal.fauzi.if99@gmail.com
 */
fun View.show(isShow: Boolean = true) {
    visibility = if (isShow) View.VISIBLE else View.GONE
}