package com.iqbalfauzi.movie.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.iqbalfauzi.core.extensions.observe
import com.iqbalfauzi.core.ui.BaseFragment
import com.iqbalfauzi.movie.R
import com.iqbalfauzi.movie.databinding.FragmentMovieBinding

/**
 * Movieku Created by ecbn on 3/10/21.
 */
class MovieFragment : BaseFragment<MovieViewModel, FragmentMovieBinding>(
    MovieViewModel::class,
    FragmentMovieBinding::inflate
) {
    private val mMovieVM by lazy {
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }
    private val mMainAdapter: MovieAdapter by lazy {
        val adapter = MovieAdapter()
        adapter.setListener {
            Log.d("TAGAR", "Adapter Listener() returned: $it")
        }
        return@lazy adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initView() {
        with(binding) {
            rvMovies.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = mMainAdapter
                setHasFixedSize(true)
            }
        }
    }

    private fun initData() {
        with(mMovieVM) {
            observe(movie) {
                mMainAdapter.setItems(it)
            }
            getMovies()
        }
    }
}