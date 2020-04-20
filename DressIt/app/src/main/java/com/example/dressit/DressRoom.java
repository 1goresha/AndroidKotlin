package com.example.dressit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DressRoom extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress_room);

        textView = findViewById(R.id.userNameTextView);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");

        setTitle(userName + " : Room");
    }
}
