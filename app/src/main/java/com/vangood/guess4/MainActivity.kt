package com.vangood.guess4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.vangood.guess4.databinding.ActivityMainBinding
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun run(view :View){
        val weight = binding.tnWeight.text.toString().toFloat()
        val height = binding.tnHeight.text.toString().toFloat()
        val bmi = weight/(height*height)
        Toast.makeText(this,"your bmi is $bmi",Toast.LENGTH_LONG).show()

    }
    val secretNumber = SelectNum()
    fun guess(view: View){
        val num = binding.tnGuess.text.toString().toInt()
        val n = secretNumber.diff(num)
        var message = "You win the game the secret number is $num"
        if (n < 0){
            message = "Bigger!"
        }else if (n > 0){
            message = "Smaller!"
        }else{
            secretNumber.replay()
        }
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        binding.tvCount.setText(secretNumber.count.toString())
    }


}

