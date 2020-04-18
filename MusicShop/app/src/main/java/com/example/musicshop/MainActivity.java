package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantityText = 0;
    ArrayList spinnerArrayList;
    Spinner spinner;
    ArrayAdapter spinnerAdapter;
    HashMap goodsMap;
    String spinnerItem;
    double price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinner = findViewById(R.id.spinnerOfGoods);

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

        //можно и так, это называется анонимный класс:
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                spinnerItem = spinner.getSelectedItem().toString();
//                price = (double) goodsMap.get(spinnerItem);
//                TextView currencyText = findViewById(R.id.сurrencyText);
//                currencyText.setText("" + price * quantityText);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        goodsMap = new HashMap();
        goodsMap.put("guitar", 500d);
        goodsMap.put("drums", 1500d);
        goodsMap.put("keyboard", 1000d);

    }

    public void increaseQuantityText(View view) {
        quantityText++;
        TextView quantityCountText = findViewById(R.id.quantityCountText);
        quantityCountText.setText("" + quantityText);
        TextView currencyText = findViewById(R.id.сurrencyText);
        currencyText.setText("" + price * quantityText);
    }

    public void decreaseQuantityText(View view) {
        quantityText--;
        if (quantityText<0){
            quantityText = 0;
        }
        TextView quantityCountText = findViewById(R.id.quantityCountText);
        quantityCountText.setText("" + quantityText);
        TextView currencyText = findViewById(R.id.сurrencyText);
        currencyText.setText("" + price * quantityText);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerItem = spinner.getSelectedItem().toString();
        price = (double) goodsMap.get(spinnerItem);
        TextView currencyText = findViewById(R.id.сurrencyText);
        currencyText.setText("" + price * quantityText);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onClickSpinner(View view){

    }
}
