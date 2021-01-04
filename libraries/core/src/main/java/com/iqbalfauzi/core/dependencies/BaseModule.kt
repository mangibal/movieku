package com.iqbalfauzi.core.dependencies

/**
 * Created by Iqbal Fauzi on 1/4/21 1:51 PM
 * iqbal.fauzi.if99@gmail.com
 */
interface BaseModule {
    /**
     * Load the module definitions into the DI's registry
     * */
    fun load()

    /**
     * Unload the module definitions from the DI's registry
     * */
    fun unload()
}