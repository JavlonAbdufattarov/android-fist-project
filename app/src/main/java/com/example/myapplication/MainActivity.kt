package com.example.myapplication

import android.os.Bundle
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
            counter++
            printValue = 50 - counter
            if (printValue<0){
                counter=0
                printValue =0
                biding.textView5.text = "Пасажиров слижком много!"

            }
            else {
                biding.textView5.text = "Осталость мест: " + printValue.toString()
            }
        }
        biding.mines.setOnClickListener {
            if(counter == 0){
                counter = 0
            }
            else{
                counter--
                printValue = MAX_VALUES - counter
            biding.textView5.text = "Осталость мест: "+ printValue.toString()
        }}

        biding.bottom.setOnClickListener{
            biding.textView5.text = "bottom is clicked!"
        }


    }

}