package com.example.viedos.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VideosActionTable(
    @PrimaryKey val actionType: String,
    val titleVideo: String,
    val time: Long
)
