package com.iqbalfauzi.movie.movie

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.iqbalfauzi.core.ui.BaseAdapter
import com.iqbalfauzi.movie.databinding.ItemMovieBinding

/**
 * Movieku Created by ecbn on 3/10/21.
 */
class MovieAdapter : BaseAdapter<Movie, ItemMovieBinding, MovieAdapter.ViewHolder>(ItemMovieBinding::inflate) {

    inner class ViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root), Binder<Movie>{
        override fun bind(data: Movie){
            with(binding){
                tvTitle.text = data.title
                tvSubTitle.text = data.subTitle
                root.setOnClickListener {
                    listenerContainData.invoke(data)
                }
            }
        }
    }
    override fun getViewHolder(view: ViewBinding): MovieAdapter.ViewHolder {
        return ViewHolder(view as ItemMovieBinding)
    }
}