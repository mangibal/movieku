package com.iqbalfauzi.data

import com.iqbalfauzi.data.model.MovieEntity
import com.iqbalfauzi.data.remote.MovieRemote
import com.skydoves.sandwich.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Iqbal Fauzi on 1/6/21 2:24 PM
 * iqbal.fauzi.if99@gmail.com
 */
class Repository(private val movieRemote: MovieRemote) {

    suspend fun getNowPlayingMovie(
        page: Int = 1,
        apiCallback: ApiCallback<List<MovieEntity>>,
    ) = flow {
        var movies: List<MovieEntity>
        val response = movieRemote.getNowPlayingMovie(page)
        // On Success Call
        response.suspendOnSuccess {
            if (data != null) {
                movies = data?.results ?: emptyList()
                emit(movies)
                apiCallback.onSuccess(movies)
            }
        }
            // handle the case when the API request gets an error response.
            // e.g. internal server error.
            .onError {
                apiCallback.onError(message())
            }
            // handle the case when the API request gets an exception response.
            // e.g. network connection error.
            .onException {
                apiCallback.onException(message())
            }
    }.flowOn(Dispatchers.IO).collect()

}