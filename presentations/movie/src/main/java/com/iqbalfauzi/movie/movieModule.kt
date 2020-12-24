package com.iqbalfauzi.movie

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Iqbal Fauzi on 12/24/20 3:16 PM
 * iqbal.fauzi.if99@gmail.com
 */
val movieModule = module {
    viewModel { MainViewModel() }
}