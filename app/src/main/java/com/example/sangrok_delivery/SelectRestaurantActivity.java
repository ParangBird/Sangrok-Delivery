package com.example.sangrok_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SelectRestaurantActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RestaurantAdapter viewAdapter;
    private RecyclerView.LayoutManager viewManager;

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
        /*
        *         recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setFocusable(false);

        postAdapter = new PostAdapter(this);
        recyclerView.setAdapter(postAdapter);
        postAdapter.setData(getDataPost());

        *
        *
        * */
    }
}