package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var counter = 0
    val MAX_VALUES= 50
    var printValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        biding.textView5.text=counter.toString()
        biding.textView5.text = getText(R.string.testText)
        biding.sw.setOnClickListener{

            if(MAX_VALUES>counter){
                counter++
            printValue = 50 - counter
            }
            if (printValue==0){
                biding.textView5.apply {
                    text = "Пассажиров слишком много!"
                    setTextColor(resources.getColor(android.R.color.holo_red_dark))

                }

            }
            else {
                biding.textView5.apply { text = "Осталость мест: " + printValue.toString()
                    setTextColor(resources.getColor(android.R.color.holo_blue_dark))  }
            }

        }

        biding.mines.setOnClickListener {
            if(counter == 0){
                counter = 0
            }
            else{
                counter--
                printValue = MAX_VALUES - counter
            biding.textView5.apply { text = "Осталость мест: " + printValue.toString()
                setTextColor(resources.getColor(android.R.color.holo_blue_dark))  }
            }
        }

        biding.bottom.setOnClickListener{
            counter = 0
            printValue = 0
            biding.textView5.apply { text = "Все места свободны"
                setTextColor(resources.getColor(android.R.color.holo_green_dark))  }


        }

         fun updateButtonVisibility(binding: ActivityMainBinding) {
            if (counter == MAX_VALUES) {
                binding.bottom.visibility = View.VISIBLE
            } else {
                binding.bottom.visibility = View.GONE
            }
        }


    }

}