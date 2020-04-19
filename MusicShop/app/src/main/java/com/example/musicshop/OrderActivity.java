package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.drm.DrmStore;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    TextView orderText;
    String[] emails;
    String subject;
    String emailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("My Order");
        emails = new String[]{"i.deryabin2017@mail.ru"};
        subject = "new order";
        orderText = findViewById(R.id.orderText);
        Intent intent = getIntent();
        String customerName = "Имя покупателя : " + intent.getStringExtra("customerName");
        String goodsName = "Наименование товара : " + intent.getStringExtra("goodsName");
        String quantity = "Количество товаров : " + intent.getIntExtra("quantity", 0);
        String price = "Стоимость товара заказа : " + intent.getDoubleExtra("price", 0);
        String orderPrice = "Общая стоимость товара заказа : " + intent.getDoubleExtra("orderPrice", 0);
        emailBody = customerName + "\n" + goodsName + "\n" + quantity + "\n" + price + "\n" + orderPrice;
        orderText.setText(emailBody);
    }

    public void makeOrder(View view) {
        //это implicit intent , то есть неявный intent, в котором мы не указываем с какого activity
        // и в какой activity мы хотим отправить intent , вместо этого мы яказываем действие action
        // , которое мы хотим совершить и указывает данные которые хотим отправить
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));//это нужно для того, чтобы только email приложение обработало этот intent
        emailIntent.putExtra(Intent.EXTRA_EMAIL, emails);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);
        if (emailIntent.resolveActivity(getPackageManager()) != null){
            startActivity(emailIntent);
        }
    }
}
