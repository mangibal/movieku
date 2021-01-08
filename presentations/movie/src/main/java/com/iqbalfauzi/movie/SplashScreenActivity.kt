package com.iqbalfauzi.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.iqbalfauzi.core.ui.BaseActivity
import com.iqbalfauzi.movie.databinding.ActivitySplashScreenBinding

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
@Suppress("DEPRECATION")
class SplashScreenActivity :
    BaseActivity<MainViewModel, ActivitySplashScreenBinding>(
        MainViewModel::class,
        ActivitySplashScreenBinding::inflate
    ) {

    private val hideHandler = Handler()

    @SuppressLint("InlinedApi")
    private val hidePart2Runnable = Runnable {
        // Delayed removal of status and navigation bar

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        with(mBinding) {
            fullscreenContent.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
    }

    private val showPart2Runnable = Runnable {
        with(mBinding) {
            // Delayed display of UI elements
//            supportActionBar?.show()
            fullscreenContentControls.visibility = View.VISIBLE
        }
    }

    private var isFullscreen: Boolean = false

    private val hideRunnable = Runnable { hide() }

    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private val delayHideTouchListener = View.OnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS)
            }
            MotionEvent.ACTION_UP -> view.performClick()
            else -> {

            }
        }
        false
    }

    override fun loadDependencies() {
        MovieModule.load()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onInitUI(savedInstanceState: Bundle?) {
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        isFullscreen = true

        with(mBinding) {
            // Set up the user interaction to manually show or hide the system UI.
            fullscreenContent.setOnClickListener { toggle() }

            // Upon interacting with UI controls, delay any scheduled hide()
            // operations to prevent the jarring behavior of controls going away
            // while interacting with the UI.
            mBinding.dummyButton.setOnTouchListener(delayHideTouchListener)

            with(mViewModel) {
                getNowPlayingMovie()
                movieData.observe(this@SplashScreenActivity, {
                    Toast.makeText(
                        this@SplashScreenActivity, it.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                })

                toastLiveData.observe(this@SplashScreenActivity, {
                    Toast.makeText(this@SplashScreenActivity, it, Toast.LENGTH_SHORT).show()
                })

                isLoading.observe(this@SplashScreenActivity, {
                    if (it) {
                        pbLoading.visibility = View.VISIBLE
                    } else {
                        pbLoading.visibility = View.GONE
                    }
                })
            }
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100)
    }

    private fun toggle() {
        if (isFullscreen) {
            hide()
        } else {
            show()
        }
    }

    private fun hide() {
        with(mBinding) {
            // Hide UI first
//            supportActionBar?.hide()
            fullscreenContentControls.visibility = View.GONE
            isFullscreen = false

            // Schedule a runnable to remove the status and navigation bar after a delay
            hideHandler.run {
                removeCallbacks(showPart2Runnable)
                postDelayed(hidePart2Runnable, UI_ANIMATION_DELAY.toLong())
            }
        }
    }

    private fun show() {
        with(mBinding) {
            // Show the system bar
            fullscreenContent.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            isFullscreen = true

            // Schedule a runnable to display UI elements after a delay
            hideHandler.run {
                removeCallbacks(hidePart2Runnable)
                postDelayed(showPart2Runnable, UI_ANIMATION_DELAY.toLong())
            }
        }
    }

    /**
     * Schedules a call to hide() in [delayMillis], canceling any
     * previously scheduled calls.
     */
    private fun delayedHide(delayMillis: Int) {
        hideHandler.run {
            removeCallbacks(hideRunnable)
            postDelayed(hideRunnable, delayMillis.toLong())
        }
    }

    companion object {
        /**
         * Whether or not the system UI should be auto-hidden after
         * [AUTO_HIDE_DELAY_MILLIS] milliseconds.
         */
        private const val AUTO_HIDE = true

        /**
         * If [AUTO_HIDE] is set, the number of milliseconds to wait after
         * user interaction before hiding the system UI.
         */
        private const val AUTO_HIDE_DELAY_MILLIS = 3000

        /**
         * Some older devices needs a small delay between UI widget updates
         * and a change of the status and navigation bar.
         */
        private const val UI_ANIMATION_DELAY = 300
    }
}