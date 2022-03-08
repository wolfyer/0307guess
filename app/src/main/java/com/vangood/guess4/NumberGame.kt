package com.vangood.guess4

class NumberGame {
    var secretnum : Int = 0
    var count = 0
    var end =false
    init {
        resetgame()
    }
    fun resetgame(){
        secretnum = (1..10).random().toInt()
        count =0
        end =false
    }
    fun diffmessage(num:Int):String{
        count++
        var message = if (num > secretnum){
            "Smaller"
        }else if (num < secretnum){
            "Bigger"
        }else{
            end =true
            "You got it!"
        }
        return message
    }
}