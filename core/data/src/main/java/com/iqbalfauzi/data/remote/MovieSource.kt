package com.iqbalfauzi.data.remote

import com.iqbalfauzi.data.model.MovieResponse
import com.iqbalfauzi.data.model.detail.Movie
import com.skydoves.sandwich.ApiResponse

/**
 * Created by Iqbal Fauzi on 1/6/21 1:29 PM
 * iqbal.fauzi.if99@gmail.com
 */
interface MovieSource {

    suspend fun getNowPlayingMovie(requestPage: Int = 1): ApiResponse<MovieResponse>
    suspend fun getMovie(movieId: Int = 1): ApiResponse<Movie>

}