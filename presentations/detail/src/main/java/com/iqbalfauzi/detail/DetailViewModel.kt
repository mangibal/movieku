package com.iqbalfauzi.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.iqbalfauzi.core.viewmodel.BaseViewModel
import com.iqbalfauzi.data.Repository
import com.iqbalfauzi.data.model.detail.Movie
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : BaseViewModel() {

    private val _movieData: MutableLiveData<Movie> = MutableLiveData()
    val movieData: LiveData<Movie> = _movieData

    private val _movieTitleData: MutableLiveData<String> = MutableLiveData()
    val movieTitleData: LiveData<String> = _movieTitleData

    private val _messageLiveData: MutableLiveData<String> = MutableLiveData()
    val messageLiveData: LiveData<String> get() = _messageLiveData

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getMovie(movieId: Int) {
        _isLoading.postValue(true)
        viewModelScope.launch(viewModelScope.coroutineContext) {
            val first = repository.getMovie(556,
                {
                    _isLoading.postValue(false)
                }, {
                    _isLoading.postValue(false)
                    _messageLiveData.postValue(it)
                })
            val second = repository.getMovie(550,
                {
                    _isLoading.postValue(false)
                }, {
                    _isLoading.postValue(false)
                    _messageLiveData.postValue(it)
                })

            /**
             * Customizable but if one request was fail, then it will canceled the others
             * */
            combine(first, second){ first, second ->
                "${first?.originalTitle} - ${second?.originalTitle}"
            }.collect {
                _movieTitleData.postValue(it)
            }

            /**
             * Still showing the success result if another request was fail to load
             * but this is still ExperimentalCoroutinesApi
             */
            merge(first, second).collect {
                _movieData.postValue(it)
            }
        }
    }

    override fun onCleared() {
        DetailModule.unload()
        super.onCleared()
    }
}