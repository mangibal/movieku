package com.iqbalfauzi.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Movieku Created by ecbn on 3/10/21.
 */
abstract class BaseAdapter<T, V : ViewBinding, VH : RecyclerView.ViewHolder>(viewBinder: (LayoutInflater) -> ViewBinding) : RecyclerView.Adapter<VH>() {
    var mListItems: List<T>
    var mListItemsFiltered: List<T>
    var listenerContainData: ((T) -> Unit) = {}
    private val mViewBinding = viewBinder

    init {
        mListItems = emptyList()
        mListItemsFiltered = emptyList()
    }

    fun setListener(listener: ((T) -> Unit)) {
        this.listenerContainData = listener
    }

    fun setItems(listItems: List<T>?) {
        this.mListItems = listItems ?: listOf()
        this.mListItemsFiltered = listItems ?: listOf()
        notifyDataSetChanged()
    }

    fun refreshRecyclerView() {
        notifyDataSetChanged()
    }

    val isEmpty get() = mListItemsFiltered.isEmpty()

    override fun getItemCount(): Int {
        return mListItemsFiltered.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = mViewBinding.invoke(inflater) as V
        return getViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        (holder as Binder<T>).bind(mListItemsFiltered[position])
        holder.itemView.tag = mListItemsFiltered[position]
    }

    abstract fun getViewHolder(view: ViewBinding): VH

    interface Binder<T> {
        fun bind(data: T)
    }
}