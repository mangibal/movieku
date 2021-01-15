package com.iqbalfauzi.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

/**
 * Created by Iqbal Fauzi on 1/4/21 1:57 PM
 * iqbal.fauzi.if99@gmail.com
 */
abstract class BaseViewModel : ViewModel() {

    inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
        return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
            emitSource(block())
        }
    }

//    fun launchOnMain(coroutine: suspend CoroutineScope.() -> Unit) =
//        launchOnViewModelScope(dispatcher.main, coroutine)
//
//    fun launchOnBack(coroutine: suspend CoroutineScope.() -> Unit) =
//        launchOnViewModelScope(dispatcher.io, coroutine)
//
//    fun launchOnComputation(coroutine: suspend CoroutineScope.() -> Unit) =
//        launchOnViewModelScope(dispatcher.computation, coroutine)
//
//    fun launchOnDb(coroutine: suspend CoroutineScope.() -> Unit) =
//        launchOnViewModelScope(dispatcher.db, coroutine)
//
//    private fun launchOnViewModelScope(
//        coroutineDispatcher: CoroutineDispatcher,
//        coroutine: suspend CoroutineScope.() -> Unit
//    ) = viewModelScope.launch(coroutineDispatcher, block = coroutine)

}