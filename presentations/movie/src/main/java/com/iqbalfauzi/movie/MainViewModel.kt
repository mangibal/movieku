package com.iqbalfauzi.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.iqbalfauzi.core.viewmodel.BaseViewModel
import com.iqbalfauzi.data.Repository
import com.iqbalfauzi.data.model.MovieEntity

/**
 * Created by Iqbal Fauzi on 12/24/20 3:15 PM
 * iqbal.fauzi.if99@gmail.com
 */
class MainViewModel(private val repository: Repository) :
    BaseViewModel() {

    private val _movieData: MutableLiveData<List<MovieEntity>> = MutableLiveData()
    var movieLiveData: LiveData<List<MovieEntity>> = _movieData

    private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
    val toastLiveData: LiveData<String> get() = _toastLiveData

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getNowPlayingMovie() {
        _isLoading.postValue(true)
        launchOnViewModelScope {
            repository.getNowPlayingMovie(
                1,
                onSuccess = {
                    _isLoading.postValue(false)
                },
                onError = {
                    _isLoading.postValue(false)
                    _toastLiveData.postValue(it)
                }
            ).asLiveData()
        }
    }

    override fun onCleared() {
        MovieModule.unload()
        super.onCleared()
    }


}