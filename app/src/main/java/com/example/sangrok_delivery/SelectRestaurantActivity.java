package com.example.sangrok_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.sangrok_delivery.DeliveryActivity;
import com.example.sangrok_delivery.adapter.RestaurantAdapter;
import com.example.sangrok_delivery.data.Restaurant;
import com.example.sangrok_delivery.slider.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;

import java.util.ArrayList;

public class SelectRestaurantActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RestaurantAdapter viewAdapter;
    private RecyclerView.LayoutManager viewManager;
    private ImageButton delivery;
    private ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_restaurant);

        recyclerView = findViewById(R.id.recyclerview_main);
        viewManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true);
        viewAdapter = new RestaurantAdapter(this);
        recyclerView.setAdapter(viewAdapter);

        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("상록원", "상록원"));
        restaurants.add(new Restaurant("기숙사식당", "신공학관 1층"));
        restaurants.add(new Restaurant("가든쿡", "학술문화관 지하 1층"));
        restaurants.add(new Restaurant("그루터기", "경영관 지하"));

        viewAdapter.setData(restaurants);


        // delivery
        delivery = findViewById(R.id.delivery);
        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), DeliveryActivity.class);
                startActivity(intent2);
            }
        });

        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), SelectRestaurantActivity.class);
                startActivity(intent2);
            }
        });
    }
}