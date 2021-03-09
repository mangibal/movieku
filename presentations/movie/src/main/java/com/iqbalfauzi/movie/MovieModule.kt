package com.iqbalfauzi.movie

import com.iqbalfauzi.core.dependencies.BaseModule
import com.iqbalfauzi.movie.movie.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module

/**
 * Created by Iqbal Fauzi on 12/24/20 3:16 PM
 * iqbal.fauzi.if99@gmail.com
 */
object MovieModule : BaseModule {

    override fun load() {
        unloadKoinModules(movieModule)
        loadKoinModules(movieModule)
    }

    override fun unload() = unloadKoinModules(movieModule)

}

val movieModule = module {
    viewModel { MainViewModel() }
    viewModel { MovieViewModel() }
}