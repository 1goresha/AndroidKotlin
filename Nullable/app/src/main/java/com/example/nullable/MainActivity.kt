package com.example.nullable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentForSecondActivity = Intent(this, SecondActivity::class.java)

        button.setOnClickListener {
            textView.text = editText.text
            intentForSecondActivity.putExtra("someText", textView.text.toString())
            startActivity(intentForSecondActivity)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {

        }
        super.onSaveInstanceState(outState)
    }
}
