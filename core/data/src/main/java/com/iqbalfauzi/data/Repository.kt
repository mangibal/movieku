package com.iqbalfauzi.data

import com.iqbalfauzi.data.dispatchers.AppDispatcher
import com.iqbalfauzi.data.model.MovieEntity
import com.iqbalfauzi.data.remote.MovieRemote
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Iqbal Fauzi on 1/6/21 2:24 PM
 * iqbal.fauzi.if99@gmail.com
 */
class Repository(private val movieRemote: MovieRemote, private val dispatcher: AppDispatcher) {

    suspend fun getNowPlayingMovie(
        page: Int = 1,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) = flow {
        var movies: List<MovieEntity> = emptyList()
        val response = movieRemote.getNowPlayingMovie(page)
        // On Success Call
        response.suspendOnSuccess {
            if (data != null) {
                movies = data?.results ?: emptyList()
                emit(movies)
                onSuccess()
            }
        }
            // handle the case when the API request gets an error response.
            // e.g. internal server error.
            .onError {
                onError(message())
            }
            // handle the case when the API request gets an exception response.
            // e.g. network connection error.
            .onException {
                onError(message())
            }
    }.flowOn(dispatcher.io)

}