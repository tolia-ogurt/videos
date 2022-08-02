package com.example.viedos.di

import android.content.Context
import androidx.room.Room
import com.example.viedos.room.VideosInfoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    @Provides
    @Singleton
    fun providesVideosDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        VideosInfoDatabase::class.java,
        TABLE_NAME
    ).build()

    @Provides
    @Singleton
    fun providesDao(db: VideosInfoDatabase) = db.videosActionDao()

    companion object {
        const val TABLE_NAME = "videos"
    }
}

