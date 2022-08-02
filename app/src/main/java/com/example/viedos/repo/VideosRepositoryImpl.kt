package com.example.viedos.repo

import android.content.Context
import com.example.viedos.model.Video
import com.example.viedos.model.VideoModel
import com.example.viedos.room.VideosActionDao
import com.example.viedos.room.VideosActionTable
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VideosRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val videosActionDao: VideosActionDao
) : VideosRepository {

    override suspend fun getVideosList(): List<Video> {
        return loadJsonFile().categories[0].videos
    }

    override suspend fun addVideoInfo(actionType: String, titleVideo: String) {
        videosActionDao.addVideoInfo(VideosActionTable(actionType, titleVideo, time = System.currentTimeMillis()))
    }

    private fun loadJsonFile(): VideoModel {
        val gson = Gson()
        val json = context.assets.open("videos.json").bufferedReader().use { it.readText() }
        return gson.fromJson(json, VideoModel::class.java)
    }
}