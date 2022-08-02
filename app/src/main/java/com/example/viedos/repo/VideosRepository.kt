package com.example.viedos.repo

import com.example.viedos.model.Video

interface VideosRepository {
    suspend fun getVideosList(): List<Video>
    suspend fun addVideoInfo(actionType: String, titleVideo: String)
}