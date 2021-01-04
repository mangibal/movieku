package com.iqbalfauzi.core.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Iqbal Fauzi on 1/4/21 1:53 PM
 * iqbal.fauzi.if99@gmail.com
 */
interface Dispatcher {

    /** Dispatch work on Android's Main Thread **/
    val main: CoroutineDispatcher

    /** Dispatch work on a background thread (from a pool) for Networking **/
    val io: CoroutineDispatcher

    /** Dispatch work on a Database thread **/
    val db: CoroutineDispatcher

    /** Dispatch computationally-heavy work on a background thread - defined by number of cores **/
    val computation: CoroutineDispatcher

}