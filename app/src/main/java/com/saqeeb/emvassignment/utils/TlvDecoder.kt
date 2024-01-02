package com.saqeeb.emvassignment.utils

import com.saqeeb.emvassignment.db.entities.TlvData
import com.saqeeb.emvassignment.removeWhiteSpace

object TlvDecoder {
    var tlvData = TlvData()


    fun getTlv(string:String): TlvData?{
        var sequence = string
        var tlvObj: TlvData?=null

        val tag = getTag(sequence)
        sequence = sequence.substring(tag.length)
        val length = getLength(sequence)
        val data = sequence.substring(length.length)

        tlvObj = TlvData(
            tag,
            length,
            data
        )
        return tlvObj
    }

    fun getLength(string: String):String{
        var length = "${string[0]}${string[1]}"
        var lengthByte = 1

        if((length.toInt(16) and Constants.CONST_LEN) == Constants.CONST_LEN){
            lengthByte = "${length[1]}".toInt(16)*2
        }
        if(lengthByte > 1){
            for(i in 2..lengthByte step 2){
                length = length + string[i] +string[i+1]
            }
        }
        return length
    }

    fun getTag(string: String):String{
        var tag = "${string[0]}${string[1]}"
        if((tag.toInt(16) and Constants.CONST_IDTAG) == Constants.CONST_IDTAG)
            tag = "$tag${string[2]}${string[3]}"
        return tag
    }
    fun getTotalLength(length:String): Int {
        var len = length
        if(len.length > 2){
            len = len.substring(2)
            return len.toInt(16) * 2
        }
        return len.toInt(16) * 2
    }
    fun parse(string: Any?): Any? {
        var sequence = string
        val dataList = ArrayList<TlvData>()
        if(sequence is String){
            return getTlv(sequence)
        }else if (sequence is ArrayList<*>){
            sequence.forEach {
                println((it as TlvData).toString())
            }
        }
        return dataList

    }

    fun parseTLV(string: String){
        val tlv = ArrayList<TlvData>()
        var sequence = string.removeWhiteSpace()
        while (sequence.isNotEmpty()){
            val obj = getTlv(sequence)
            sequence = sequence.substring(obj?.getTotalSequence()!!)
            tlv.add(obj)
        }
        tlvData.data = tlv
        (tlvData.data as ArrayList<*>).forEach {
            (it as TlvData).computeChildren()
        }
    }
}

fun main() {
    val decoder = TlvDecoder.parseTLV("6F1A840E315041592E5359532E4444463031A5088801025F2D02656E")
    println(decoder)
}