package com.vangood.guess4

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.vangood.guess4.databinding.ActivityMainBinding


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
            AlertDialog.Builder(this)
                .setTitle("WIN")
                .setMessage("want to replay again?")
                .setPositiveButton("OK"){ dialog, which ->secretNumber.replay()}
                .show()
        }
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        binding.tvCount.setText(secretNumber.count.toString())
        //binding.textView3.setTextColor(0xffff00ff)
    }

}

