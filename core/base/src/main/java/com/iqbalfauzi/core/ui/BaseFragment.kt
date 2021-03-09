package com.iqbalfauzi.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

/**
 * Movieku Created by ecbn on 3/10/21.
 */
abstract class BaseFragment<out VM : ViewModel, VB : ViewBinding>(
    kClass: KClass<VM>,
    viewBinder: (LayoutInflater) -> ViewBinding
)  : Fragment() {
    protected val mViewModel: VM by viewModel(kClass)
    protected lateinit var binding: VB
    var rootView: View? = null
    private val mViewBinding = viewBinder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = mViewBinding.invoke(inflater) as VB
        rootView = binding.root
        return rootView
    }
}