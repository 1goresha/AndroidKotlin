package com.example.clothingstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerMenu;
    ArrayList<String> spinnerArray;
    ArrayAdapter spinnerArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerMenu = findViewById(R.id.spinnerMenu);

        spinnerArray = new ArrayList<>();
        spinnerArray.add("Личный кабинет");
        spinnerArray.add("Настройки");
        spinnerArray.add("еще что то");
        spinnerArray.add("Выход");

        spinnerArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArray );
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMenu.setAdapter(spinnerArrayAdapter);
        spinnerMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinnerString = spinnerMenu.getSelectedItem().toString();

                switch(spinnerString){
                    case "Личный кабинет" : goToPersonalArea("Welcome");
                    break;
                    case "Настройки"    :   doToastMessage("Временно не работает");
                    break;
                    case "еще что то"   :   doToastMessage("Временно не работает");
                    break;
                    case "Выход"    :   doToastMessage("Временно не работает");
                    break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    void goToPersonalArea(String intentStringValue){
        Intent intent = new Intent(this, PersonalArea.class);
        intent.putExtra("message", intentStringValue);
        startActivity(intent);
    }

    void doToastMessage(String toastMessage){
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
