package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {

    val ccount = "ccount"

    companion object{
    const val COUNT = "count"
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomDigit()
    }

    fun showRandomDigit() : Unit{
        val countFromMainActivity = intent.getIntExtra("count", 0)
        textView2.text = getString(R.string.textWithRandomDigitInSecondActivity, countFromMainActivity)
        val random = Random()
        if (countFromMainActivity > 0){
            textView3.text = random.nextInt(countFromMainActivity + 1).toString()
        }
    }

}
