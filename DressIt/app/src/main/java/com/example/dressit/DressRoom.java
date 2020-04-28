package com.example.dressit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DressRoom extends AppCompatActivity {

    private TextView textView;
    private ArrayList<Integer> hats;
    private Integer currentCountOfHat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress_room);

        currentCountOfHat = 0;
        hats = new ArrayList<>();
        hats.add(R.drawable.hat1);
        hats.add(R.drawable.hat2);
        hats.add(R.drawable.hat3);
        hats.add(R.drawable.hat4);
        hats.add(R.drawable.hat5);
        hats.add(R.drawable.hat6);
        hats.add(R.drawable.hat7);
        hats.add(R.drawable.hat8);
        hats.add(R.drawable.hat9);
        hats.add(R.drawable.hat10);
        textView = findViewById(R.id.userNameTextView);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");

        setTitle(userName + " : Room");
    }

    public void doNextHat(View view) {
        if (currentCountOfHat > hats.size() - 1) {
            currentCountOfHat = 0;
        }else if (currentCountOfHat < 0) {
            currentCountOfHat = hats.size() - 1;
        }
        ImageView hat = findViewById(R.id.hat);
        hat.setImageResource(hats.get(currentCountOfHat));
        currentCountOfHat++;
    }

    public void doPreviousHat(View view) {
        if (currentCountOfHat < 0) {
            currentCountOfHat = hats.size() - 1;
        }else if (currentCountOfHat > hats.size() - 1) {
            currentCountOfHat = 0;
        }
        ImageView hat = findViewById(R.id.hat);
        hat.setImageResource(hats.get(currentCountOfHat));
        currentCountOfHat--;
    }
}
