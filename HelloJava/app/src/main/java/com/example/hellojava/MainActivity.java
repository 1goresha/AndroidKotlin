package com.example.hellojava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setHelloWorldInTextView(View view){
        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello Java");
        textView.setBackgroundColor(Color.YELLOW);
        textView.setTextSize(30);
    }
}