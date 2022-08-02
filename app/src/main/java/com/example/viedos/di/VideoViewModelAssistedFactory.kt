package com.example.viedos.di

import androidx.savedstate.SavedStateRegistryOwner
import com.example.viedos.ui.VideoViewModelFactory
import dagger.assisted.AssistedFactory

@AssistedFactory
interface VideoViewModelAssistedFactory {
    fun create(owner: SavedStateRegistryOwner): VideoViewModelFactory
}