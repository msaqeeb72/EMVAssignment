package com.saqeeb.emvassignment.db.dao

import com.saqeeb.emvassignment.db.entities.TlvData


interface TlvDataDao {

    suspend fun insertTlvData(tlv: TlvData)


    suspend fun getAllTlv(): List<TlvData>
}