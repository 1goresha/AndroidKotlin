package com.example.appjustforexp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    ArrayList<String> spinnerList;
    Spinner spinner;
    ArrayAdapter spinnerArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerMain);

        spinnerList = new ArrayList();
        spinnerList.add("еще что то там");
        spinnerList.add("Личный кабинет");
        spinnerList.add("еще что то там");

        spinnerArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerList);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String menuString = spinner.getSelectedItem().toString();
                switch (menuString){
                    case  "Личный кабинет" : goToTheSecondActivityWithSomeMessage(menuString);
                    break;
                    case "еще что то там"   : doToastWithErrorMessage("ERROR!!!!!!!!!!!!!!");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    void doToastWithErrorMessage(String errorMessage){
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    void goToTheSecondActivityWithSomeMessage(String someMessage){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("someText", someMessage);
        this.startActivity(intent);
    }

}
