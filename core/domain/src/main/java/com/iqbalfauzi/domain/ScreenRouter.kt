package com.iqbalfauzi.domain

import android.app.Activity
import android.app.ActivityOptions
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Iqbal Fauzi on 2/12/21 9:44 AM
 * iqbal.fauzi.if99@gmail.com
 */
object ScreenRouter {

    private const val BASE_PACKAGE = "com.iqbalfauzi"
    private const val DETAIL_MODULE = ".detail"
    const val DETAIL_ACTIVITY = "$BASE_PACKAGE$DETAIL_MODULE.DetailActivity"

    fun Activity.goToActivityForResult(className: String, bundle: Bundle?, requestCode: Int) {
        val i = Intent(this, Class.forName(className))
        if (bundle != null) {
            i.putExtras(bundle)
        }
        startActivityForResult(i, requestCode)
    }

    fun goToActivity(
        context: AppCompatActivity,
        className: String,
        bundle: Bundle? = null,
        isFinish: Boolean = false
    ) {
        try {
            with(context) {
                val screen = Intent(this, Class.forName(className))
                bundle?.let {
                    screen.putExtras(bundle)
                }
                startActivity(
                    screen,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
                )
                if (isFinish) {
                    finish()
                }
            }
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
//            showToast("Activity Not Found")
        }
    }

    fun goToActivityClearStack(
        context: AppCompatActivity,
        className: String,
        bundle: Bundle? = null
    ) {
        try {
            with(context) {
                val screen = Intent(this, Class.forName(className))
                bundle?.let {
                    screen.putExtras(bundle)
                }
                screen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(screen, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                finish()
            }
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
        }
    }

}