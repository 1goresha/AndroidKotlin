package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantityOfGoods = 0;
    ArrayList spinnerArrayList;
    Spinner spinner;
    ArrayAdapter spinnerAdapter;
    HashMap goodsMap;
    String goodsName;
    double price;
    EditText customerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();
        createMap();

        customerName = findViewById(R.id.customerName);
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
    }

    void createSpinner(){
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinner = findViewById(R.id.spinnerOfGoods);

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    void createMap(){
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500d);
        goodsMap.put("drums", 1500d);
        goodsMap.put("keyboard", 1000d);
    }

    public void increaseQuantityText(View view) {
        quantityOfGoods++;
        TextView quantityCountText = findViewById(R.id.quantityCountText);
        quantityCountText.setText("" + quantityOfGoods);
        TextView currencyText = findViewById(R.id.сurrencyText);
        currencyText.setText("" + price * quantityOfGoods);
    }

    public void decreaseQuantityText(View view) {
        quantityOfGoods--;
        if (quantityOfGoods <0){
            quantityOfGoods = 0;
        }
        TextView quantityCountText = findViewById(R.id.quantityCountText);
        quantityCountText.setText("" + quantityOfGoods);
        TextView currencyText = findViewById(R.id.сurrencyText);
        currencyText.setText("" + price * quantityOfGoods);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);
        TextView currencyText = findViewById(R.id.сurrencyText);
        currencyText.setText("" + price * quantityOfGoods);
        ImageView imageView = findViewById(R.id.goodsImage);

        switch(goodsName){
            case "guitar" :
                imageView.setImageResource(R.drawable.stratocaster_dender_guitar);
                break;
            case "drums" :
                imageView.setImageResource(R.drawable.drums);
                break;
            case "keyboard" :
                imageView.setImageResource(R.drawable.keyboard);
                break;
            default:
                imageView.setImageResource(R.drawable.stratocaster_dender_guitar);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addToCart(View view) {
        Order order = new Order();
        order.customerName = customerName.getText().toString();
        order.goodsName = goodsName;
        order.quantity = quantityOfGoods;
        order.price = price;
        order.orderPrice = price * quantityOfGoods;

        Intent intentOrder = new Intent(this, OrderActivity.class);
        intentOrder.putExtra("customerName", order.customerName);
        intentOrder.putExtra("goodsName", order.goodsName);
        intentOrder.putExtra("quantity", order.quantity);
        intentOrder.putExtra("price", order.price);
        intentOrder.putExtra("orderPrice", order.orderPrice);
        startActivity(intentOrder);
    }
}
