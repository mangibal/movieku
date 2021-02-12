package com.iqbalfauzi.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * Created by Iqbal Fauzi on 12/24/20 2:55 PM
 * iqbal.fauzi.if99@gmail.com
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<out VM : ViewModel, VB : ViewBinding>(
    kClass: KClass<VM>,
    private val viewBinder: (LayoutInflater) -> ViewBinding
) : AppCompatActivity() {

    protected val mViewModel: VM by viewModel(kClass)
    protected val mBinding by lazy(LazyThreadSafetyMode.NONE) { viewBinder.invoke(layoutInflater) as VB }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        if (savedInstanceState == null) {
            loadDependencies()
        }
        onInitUI(savedInstanceState)
    }

    abstract fun onInitUI(savedInstanceState: Bundle?)

    open fun loadDependencies() {}

}