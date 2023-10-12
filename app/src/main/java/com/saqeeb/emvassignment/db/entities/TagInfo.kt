package com.saqeeb.emvassignment.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tag_info")
data class TagInfo(@PrimaryKey val tagId :String,val description:String)
