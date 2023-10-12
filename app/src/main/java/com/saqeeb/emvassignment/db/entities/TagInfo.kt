package com.saqeeb.emvassignment.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tag_info")
data class TagInfo(@PrimaryKey var tag:String, var description:String)
