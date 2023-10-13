package com.saqeeb.emvassignment.repos

import com.saqeeb.emvassignment.db.dao.TagInfoDao
import com.saqeeb.emvassignment.db.dao.TlvDataDao
import javax.inject.Inject

class HomeRepo @Inject constructor(private val tlvDataDao: TlvDataDao,private val tagInfoDao: TagInfoDao) {
}