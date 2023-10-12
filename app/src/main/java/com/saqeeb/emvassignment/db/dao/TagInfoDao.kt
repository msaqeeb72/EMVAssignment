package com.saqeeb.emvassignment.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.saqeeb.emvassignment.db.entities.TagInfo
@Dao
interface TagInfoDao {
    @Insert
    suspend fun insertTagInfo(tag:TagInfo)

    @Query("SELECT * FROM tag_info")
    suspend fun getAllTags(): List<TagInfo>
    @Query("SELECT * FROM tag_info where tagId=:tag")
    suspend fun getTagInfo(tag:String): TagInfo
}
