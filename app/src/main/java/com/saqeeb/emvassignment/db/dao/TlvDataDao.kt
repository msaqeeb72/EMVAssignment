package com.saqeeb.emvassignment.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.saqeeb.emvassignment.db.entities.TlvData

@Dao
interface TlvDataDao {
    @Insert
    suspend fun insertTlvData(tlv: TlvData)

    @Query("SELECT * FROM tlv_data")
    suspend fun getAllTlv(): List<TlvData>
}