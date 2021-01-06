package com.iqbalfauzi.data.dispatchers

import kotlinx.coroutines.Dispatchers

/**
 * Created by Iqbal Fauzi on 1/4/21 1:54 PM
 * iqbal.fauzi.if99@gmail.com
 */
class AppDispatcher: Dispatcher {

    override val main = Dispatchers.Main

    override val io = Dispatchers.IO

    override val db = Dispatchers.IO

    override val computation = Dispatchers.Default

}