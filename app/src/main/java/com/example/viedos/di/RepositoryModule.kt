package com.example.viedos.di

import com.example.viedos.repo.VideosRepository
import com.example.viedos.repo.VideosRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindVideosListRepository(videosListRepositoryImpl: VideosRepositoryImpl): VideosRepository
}