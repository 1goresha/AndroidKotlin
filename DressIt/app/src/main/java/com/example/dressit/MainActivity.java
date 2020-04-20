package com.example.dressit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.userNameEditText);
    }

    public void goToDressRoom(View view) {
        Intent intent = new Intent(this, DressRoom.class);
        intent.putExtra("userName", editText.getText().toString());
        startActivity(intent);
    }
}
