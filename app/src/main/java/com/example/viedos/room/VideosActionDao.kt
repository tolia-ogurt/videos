package com.example.viedos.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface VideosActionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVideoInfo(videosActionTable: VideosActionTable)
}