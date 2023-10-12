package com.saqeeb.emvassignment.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saqeeb.emvassignment.db.dao.TagInfoDao
import com.saqeeb.emvassignment.db.dao.TlvDataDao
import com.saqeeb.emvassignment.db.entities.TagInfo

@Database(entities = [TagInfo::class,TagInfo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tagInfoDao():TagInfoDao
    abstract fun tlvDataDao():TlvDataDao
}