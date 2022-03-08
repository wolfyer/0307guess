package com.vangood.guess4

class NumberGame {
    enum class GameState{
        INIT, BIGGER, SMALLER, BINGO, END
    }
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
    fun diffmessage(num:Int):GameState{
        count++
        var message = if (num > secretnum){
            GameState.SMALLER
        }else if (num < secretnum){
            GameState.BIGGER
        }else{
            end =true
            GameState.BINGO
        }
        return message
    }
}