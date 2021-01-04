package com.iqbalfauzi.movieku

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

/**
 * Created by Iqbal Fauzi on 12/24/20 3:16 PM
 * iqbal.fauzi.if99@gmail.com
 */
class MovieApp: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

}