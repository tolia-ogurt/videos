package com.example.viedos.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viedos.model.Video
import com.example.viedos.repo.VideosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val videosListRepository: VideosRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _videos = MutableLiveData<List<Video>>()
    val videos: LiveData<List<Video>> get() = _videos

    init {
        loadVideos()
    }

    private fun loadVideos() {
        viewModelScope.launch {
            _videos.value = videosListRepository.getVideosList()
        }
    }

    fun addVideoInfo(actionType: String, titleVideo: String) {
        viewModelScope.launch {
            videosListRepository.addVideoInfo(actionType, titleVideo)
        }
    }
}