package com.example.sangrok_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ConfirmDeliverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_deliver);
        ArrayList<Integer> lists = (ArrayList<Integer>)getIntent().getSerializableExtra("lists");
    }
}