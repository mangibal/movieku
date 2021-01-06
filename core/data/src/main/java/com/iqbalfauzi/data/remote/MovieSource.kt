package com.iqbalfauzi.data.remote

import com.iqbalfauzi.data.model.MovieResponse

/**
 * Created by Iqbal Fauzi on 1/6/21 1:29 PM
 * iqbal.fauzi.if99@gmail.com
 */
interface MovieSource {

    suspend fun getNowPlayingMovie(requestPage: Int = 1): DataResult<MovieResponse>

}