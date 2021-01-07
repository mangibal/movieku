package com.iqbalfauzi.core.application

import android.app.Application
import com.iqbalfauzi.data.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

/**
 * Created by Iqbal Fauzi on 12/24/20 3:18 PM
 * iqbal.fauzi.if99@gmail.com
 */
abstract class CoreApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            // Logger for Android
            androidLogger(Level.ERROR)
            // Set the Android Context
            androidContext(this@CoreApp)
            modules(listOf(*defaultModules(), *getDataModules()))
        }
    }

    private fun defaultModules(): Array<Module> =
        arrayOf(networkModule)

    /**
     * Return the modules for Data (Dao, WebServices)
     */
    abstract fun getDataModules(): Array<Module>

}