package com.iqbalfauzi.data.repo

/**
 * Created by Iqbal Fauzi on 1/7/21 4:43 PM
 * iqbal.fauzi.if99@gmail.com
 */
interface ApiCallback<T> {
    fun onSuccess(data: T)
    fun onError(message: String)
    fun onException(message: String)
}