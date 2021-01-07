package com.iqbalfauzi.data.remote

import com.iqbalfauzi.data.model.MovieResponse
import com.skydoves.sandwich.ApiResponse

/**
 * Created by Iqbal Fauzi on 1/6/21 1:28 PM
 * iqbal.fauzi.if99@gmail.com
 */
class MovieRemote(private val apiService: ApiService) : MovieSource {

    override suspend fun getNowPlayingMovie(requestPage: Int): ApiResponse<MovieResponse> =
        apiService.getNowPlayingMovie(requestPage)

}