package com.iqbalfauzi.data.remote

import com.iqbalfauzi.data.callApi
import com.iqbalfauzi.data.model.MovieResponse

/**
 * Created by Iqbal Fauzi on 1/6/21 1:28 PM
 * iqbal.fauzi.if99@gmail.com
 */
class MovieRemote(private val apiService: ApiService) : MovieSource {

    override suspend fun getNowPlayingMovie(requestPage: Int): DataResult<MovieResponse> =
        callApi { apiService.getNowPlayingMovie(requestPage) }

}