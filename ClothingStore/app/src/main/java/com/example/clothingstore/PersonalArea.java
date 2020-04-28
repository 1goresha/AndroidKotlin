package com.example.clothingstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PersonalArea extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_area);

        Intent intent = getIntent();
        textView = findViewById(R.id.textView);
        textView.setText(intent.getStringExtra("message"));
    }
}
