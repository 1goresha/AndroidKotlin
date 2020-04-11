package com.example.nullable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    var count = 0
    var string : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


//            textView2.text = intent.getStringExtra("someText")

        button2.setOnClickListener {
            count++
            textView2.text = count.toString()
        }

        button3.setOnClickListener {
            string = editText2.text.toString()
            textView3.text  = string
        }

        button3.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v : View){
                println("hello")
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
            outState.putInt("count", count)
            outState.putString("string", string)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
        textView2.text = savedInstanceState.getInt("count").toString()
        string = savedInstanceState.getString("string")
        textView3.text = savedInstanceState.getString("string")
    }


}
