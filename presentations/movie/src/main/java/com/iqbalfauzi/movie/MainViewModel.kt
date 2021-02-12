package com.iqbalfauzi.movie

import com.iqbalfauzi.core.viewmodel.BaseViewModel

/**
 * Created by Iqbal Fauzi on 12/24/20 3:15 PM
 * iqbal.fauzi.if99@gmail.com
 */
class MainViewModel :
    BaseViewModel() {

    override fun onCleared() {
        MovieModule.unload()
        super.onCleared()
    }


}