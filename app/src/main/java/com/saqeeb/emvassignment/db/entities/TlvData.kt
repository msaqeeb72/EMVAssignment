package com.saqeeb.emvassignment.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tlv_data")
data class TlvData(
    @PrimaryKey private val tag:String?,private val dataLength:String,private val data:String?,
){
    fun intLength():Int = dataLength.toInt(16)
}