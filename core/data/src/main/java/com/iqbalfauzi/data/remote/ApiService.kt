package com.iqbalfauzi.data.remote

import com.iqbalfauzi.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Iqbal Fauzi on 1/6/21 12:55 PM
 * iqbal.fauzi.if99@gmail.com
 */
interface ApiService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(@Query("page") requestPage: Int): MovieResponse

}