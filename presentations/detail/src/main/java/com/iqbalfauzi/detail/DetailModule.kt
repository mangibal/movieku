package com.iqbalfauzi.detail

import com.iqbalfauzi.core.dependencies.BaseModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module

object DetailModule : BaseModule {

    override fun load() {
        unloadKoinModules(detailModule)
        loadKoinModules(detailModule)
    }

    override fun unload() = unloadKoinModules(detailModule)

}

val detailModule = module {
    viewModel { DetailViewModel(get()) }
}