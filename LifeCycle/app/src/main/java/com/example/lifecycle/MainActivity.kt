package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMeState(event : String){
        Toast.makeText(this, "${lifecycle.currentState} / $event", Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        toastMeState("on_start")
    }

    override fun onResume() {
        super.onResume()
        toastMeState("on_resume")
    }

    override fun onPostResume() {
        super.onPostResume()
        toastMeState("on_postResume")
    }

    override fun onPause() {
        super.onPause()
        toastMeState("on_pause")
    }

    override fun onStop() {
        super.onStop()
        toastMeState("on_stop")
    }

    override fun onRestart() {
        super.onRestart()
        toastMeState("on_restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        toastMeState("on_destroy")
    }
}
