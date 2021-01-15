package com.iqbalfauzi.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iqbalfauzi.core.viewmodel.BaseViewModel
import com.iqbalfauzi.data.repo.ApiCallback
import com.iqbalfauzi.data.repo.Repository
import com.iqbalfauzi.data.model.MovieEntity
import kotlinx.coroutines.launch

/**
 * Created by Iqbal Fauzi on 12/24/20 3:15 PM
 * iqbal.fauzi.if99@gmail.com
 */
class MainViewModel(private val repository: Repository) :
    BaseViewModel() {

    private val _movieData: MutableLiveData<List<MovieEntity>> = MutableLiveData()
    val movieData: LiveData<List<MovieEntity>> = _movieData

    private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
    val toastLiveData: LiveData<String> get() = _toastLiveData

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getNowPlayingMovie() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            repository.getNowPlayingMovie(1, object : ApiCallback<List<MovieEntity>> {

                override fun onSuccess(data: List<MovieEntity>) {
                    _isLoading.postValue(false)
                    _movieData.postValue(data)
                }

                override fun onError(message: String) {
                    _isLoading.postValue(false)
                    _toastLiveData.postValue(message)
                }

                override fun onException(message: String) {
                    _isLoading.postValue(false)
                    _toastLiveData.postValue(message)
                }
            })
        }
    }

    override fun onCleared() {
        MovieModule.unload()
        super.onCleared()
    }


}