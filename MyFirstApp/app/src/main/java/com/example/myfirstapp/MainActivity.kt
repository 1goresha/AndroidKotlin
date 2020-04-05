package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun toastMe(view : View) : Unit{
        val myToast = Toast.makeText(this, "Hello there", Toast.LENGTH_LONG)
        myToast.show()
    }

    fun countMe(view : View) : Unit{
        val countFromTextView = textView.text.toString()
        var currentCount = Integer.parseInt(countFromTextView)
        currentCount++
        textView.text = currentCount.toString()
    }

    fun randomMe(view : View) : Unit{
        val intent = Intent(this, SecondActivity::class.java)
        val countFromTextView = textView.text.toString()
        val currentCount = Integer.parseInt(countFromTextView)
        intent.putExtra("count",currentCount)
        startActivity(intent)
    }
}
