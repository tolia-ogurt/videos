package com.example.viedos.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [VideosActionTable::class], version = 1)
abstract class VideosInfoDatabase : RoomDatabase() {
    abstract fun videosActionDao(): VideosActionDao
}