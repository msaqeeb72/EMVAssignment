package com.saqeeb.emvassignment.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tlv_data")
data class TlvData(@PrimaryKey var tag:String, var dataLength:String, var data:String)
{
    fun intLength():Int = dataLength.toInt(16)
}
