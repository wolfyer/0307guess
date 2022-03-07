package com.vangood.guess4

class SelectNum {
    var ans = (1..10).random().toInt()
    var count = 0
    fun diff(num:Int):Int{
        count++
        return num-ans
    }
    fun replay(){
        ans = (1..10).random().toInt()
        count = 0
    }
}