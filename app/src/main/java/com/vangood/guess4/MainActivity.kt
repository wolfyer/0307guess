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
    val game = NumberGame()
    fun guess(view: View){
        val num = binding.tnGuess.text.toString().toInt()
            AlertDialog.Builder(this)
                .setTitle("WIN")
                .setMessage("want to replay again?")
                .setPositiveButton("OK"){ dialog, which -> if (game.end){game.resetgame()}
                    updateUI()}
                .show()
        Toast.makeText(this,game.diffmessage(num),Toast.LENGTH_LONG).show()
        updateUI()
    }
    fun updateUI(){
        binding.tvCount.text = (game.count.toString())
    }
}

