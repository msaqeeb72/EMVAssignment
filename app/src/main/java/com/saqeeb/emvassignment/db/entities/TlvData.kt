package com.saqeeb.emvassignment.db.entities

import com.saqeeb.emvassignment.utils.Constants.CONST_PC
import com.saqeeb.emvassignment.utils.TlvDecoder


data class TlvData(var tag:String? = null, var dataLength:String?=null, var data:Any?=null)
{

    fun intLength(): Int? = dataLength?.toInt(16)
    override fun toString(): String {
        return "$tag$dataLength$data"
    }
    fun getTotalSequence():Int = "$tag$dataLength$data".length

    fun isConstructed() = "${tag?.subSequence(0,2)}".toInt(16) and CONST_PC == CONST_PC


    fun computeChildren() {
        if(isConstructed()){
            val child = TlvDecoder.parse(data)
            if((child is String).not()){
                val tempChildren =  data as ArrayList<*>
                tempChildren.forEach {
                    (it as TlvData).computeChildren()
                }
            }
        }
    }




}
