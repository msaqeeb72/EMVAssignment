package com.saqeeb.emvassignment.repos

import com.saqeeb.emvassignment.db.dao.TagInfoDao
import javax.inject.Inject

class HomeRepo @Inject constructor(private val tagInfoDao: TagInfoDao) {
}