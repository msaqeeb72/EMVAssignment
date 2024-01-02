package com.saqeeb.emvassignment

fun StringBuilder.setValue(string: String){
    clear()
    append(string)
}
fun String.removeWhiteSpace(): String {
    return this.replace(" ","")
}