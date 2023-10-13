package com.saqeeb.emvassignment.utils

import com.saqeeb.emvassignment.db.entities.TlvData
import com.saqeeb.emvassignment.setValue

object TlvUtils {
    fun parseTlvStringToList(tlv:String){
        try {
            val remainingString = StringBuilder(tlv)
            while (true){
                val tlvData = decodeTlv(remainingString.toString())
                if(tlvData.tag == "6F"){
                    remainingString.setValue(tlvData.data)
                }else{
                    remainingString.setValue(remainingString.toString().replaceFirst(tlvData.toString(),""))
                }
                println(tlvData.toString())
                if(isValidTlv(remainingString.toString()).not())
                    break
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun decodeTlv(input: String) :TlvData{
        var i=0;
        val tag = input.substring(i, i+2)
        i+=2

        val lengthHex = input.substring(i, i+2)
        i+=2

        val length = lengthHex.toInt(16)


        val value = input.substring(i, i + (length * 2))


        return TlvData(tag,lengthHex,value)
    }

    fun isValidTlv(tlv:String):Boolean{
        return Regex("^([0-9A-Fa-f]{2})([0-9A-Fa-f]{2})([0-9A-Fa-f]{4,})").matches(tlv)
    }
}