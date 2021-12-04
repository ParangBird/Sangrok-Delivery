package com.example.sangrok_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SelectMenuActivity extends AppCompatActivity {


    private TextView tv_restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_menu);
        tv_restaurant = findViewById(R.id.restaurant_name);
        Intent intent = getIntent();
        String restaurant_name = intent.getStringExtra("restaurant");
        tv_restaurant.setText(restaurant_name);
    }
}