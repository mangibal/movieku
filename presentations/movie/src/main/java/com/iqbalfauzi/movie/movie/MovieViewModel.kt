package com.iqbalfauzi.movie.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

/**
 * Movieku Created by ecbn on 3/10/21.
 */
class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<ArrayList<Movie>>()
    val movie: LiveData<ArrayList<Movie>> = _movies

    fun getMovies() {
        val movies = arrayListOf<Movie>()
        for (i in 0..10) {
            movies.add(Movie(i, "Judul $i", "Sub Judul $i"))
        }
        _movies.postValue(movies)
    }
}