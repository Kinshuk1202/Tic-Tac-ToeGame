package com.example.tictctoeapp

import android.app.Activity
import android.graphics.Color
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tictctoeapp.databinding.ActivityMainBinding
import java.nio.channels.spi.AbstractSelectableChannel

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun buClick(view: View) {
        val btSelected = view as Button
        var cellId = 0
        when(btSelected.id){
            R.id.button1 ->cellId = 1
            R.id.button2 ->cellId = 2
            R.id.button3 ->cellId = 3
            R.id.button4 ->cellId = 4
            R.id.button5 ->cellId = 5
            R.id.button6 ->cellId = 6
            R.id.button7 ->cellId = 7
            R.id.button8 ->cellId = 8
            R.id.button9 ->cellId = 9
        }
        PlayGame(cellId,btSelected)
    }
    var activeplayer = 1
    var py1 = ArrayList<Int>()
    var py2 = ArrayList<Int>()
    fun PlayGame(cellId:Int, btSelect:Button)
    {
            if (activeplayer == 1) {
                btSelect.text = "X"
                btSelect.setBackgroundColor(Color.BLUE)
                btSelect.setTextColor(Color.BLACK)
                py1.add(cellId)
                activeplayer = 2
            } else {
                btSelect.text = "O"
                btSelect.setBackgroundColor(Color.GREEN)
                btSelect.setTextColor(Color.BLACK)
                py2.add(cellId)
                activeplayer = 1
            }
            btSelect.isEnabled = true
            checkwinner()

    }

     fun checkwinner() {
         var winner = -1
         if(py1.contains(1) && py1.contains(2) && py1.contains(3)){
             winner = 1
         }
         if(py2.contains(1) && py2.contains(2) && py2.contains(3)){
             winner = 2
         }
         if(py1.contains(4) && py1.contains(5) && py1.contains(6)){
             winner = 1
         }
         if(py2.contains(4) && py2.contains(5) && py2.contains(6)){
             winner = 2
         }
         if(py1.contains(7) && py1.contains(8) && py1.contains(9)){
             winner = 1
         }
         if(py2.contains(7) && py2.contains(8) && py2.contains(9)){
             winner = 2
         }
         //
        if(py1.contains(1) && py1.contains(4) && py1.contains(7)){
                     winner = 1
                 }
         if(py2.contains(1) && py2.contains(4) && py2.contains(7)){
             winner = 2
         }
         if(py1.contains(2) && py1.contains(5) && py1.contains(8)){
             winner = 1
         }
         if(py2.contains(2) && py2.contains(5) && py2.contains(8)){
             winner = 2
         }
         if(py1.contains(3) && py1.contains(6) && py1.contains(9)){
             winner = 1
         }
         if(py2.contains(3) && py2.contains(6) && py2.contains(9)){
             winner = 2
         }
         //
         if(py1.contains(1) && py1.contains(5) && py1.contains(9)){
             winner = 1
         }
         if(py2.contains(1) && py2.contains(5) && py2.contains(9)){
             winner = 2
         }
         if(py1.contains(3) && py1.contains(5) && py1.contains(7)){
             winner = 1
         }
         if(py2.contains(3) && py2.contains(5) && py2.contains(7)){
             winner = 2
         }


         if(winner == 1){
             Toast.makeText(this,"Player 1 wins!!",Toast.LENGTH_LONG).show()
             disableAllbtns()

         }
         else if(winner == 2){
             Toast.makeText(this,"Player 2 wins!!",Toast.LENGTH_LONG).show()
             disableAllbtns()
         }
         else if(py2.size+py1.size == 9){
             Toast.makeText(this,"Game Drawn!!",Toast.LENGTH_LONG).show()
         }

    }
    fun restart(view: View){
        activeplayer =1
        py1.clear()
        py2.clear()
        for(i in 1..9) {
            val btnsel:Button = when(i) {
                1-> binding.button1
                2-> binding.button2
                3-> binding.button3
                4-> binding.button4
                5-> binding.button5
                6-> binding.button6
                7-> binding.button7
                8-> binding.button8
                9-> binding.button9
                else ->{
                    binding.button1}
            }
            btnsel.isEnabled = true
            btnsel.text = "."
            btnsel.setBackgroundColor(Color.WHITE)

        }

    }
    fun disableAllbtns()
    {
        for(i in 1..9) {
            val btnsel: Button = when (i) {
                1 -> binding.button1
                2 -> binding.button2
                3 -> binding.button3
                4 -> binding.button4
                5 -> binding.button5
                6 -> binding.button6
                7 -> binding.button7
                8 -> binding.button8
                9 -> binding.button9
                else -> {
                    binding.button1
                }
            }
            btnsel.isEnabled = false
        }
    }


}