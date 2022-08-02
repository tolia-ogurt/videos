package com.example.viedos.ui

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.viedos.repo.VideosRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class VideoViewModelFactory @AssistedInject constructor(
    private val videosListRepository: VideosRepository,
    @Assisted owner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(owner, null) {

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T = VideoViewModel(videosListRepository,handle) as T

}