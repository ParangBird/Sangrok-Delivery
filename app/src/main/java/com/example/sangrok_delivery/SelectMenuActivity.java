package com.example.sangrok_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sangrok_delivery.adapter.FoodAdapter;
import com.example.sangrok_delivery.data.Food;

import java.util.ArrayList;

public class SelectMenuActivity extends AppCompatActivity {


    private TextView tv_restaurant;
    private RecyclerView recyclerView;
    private FoodAdapter viewAdapter;
    private RecyclerView.LayoutManager viewManager;
    private Button purchase_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_menu);
        tv_restaurant = findViewById(R.id.restaurant_name);
        Intent intent = getIntent();
        String restaurant_name = intent.getStringExtra("restaurant");
        //tv_restaurant.setText(restaurant_name);
        purchase_button = findViewById(R.id.purchase);

        recyclerView = findViewById(R.id.recyclerview_main);
        viewManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true);
        viewAdapter = new FoodAdapter(this);
        recyclerView.setAdapter(viewAdapter);

        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("치즈불닭", "4500"));
        foods.add(new Food("떡볶이", "3000"));
        foods.add(new Food("김밥", "2000"));
        foods.add(new Food("삼겹살김치철판", "5000"));
        foods.add(new Food("숯불삼겹솥밥", "4800"));
        foods.add(new Food("순대국밥", "5000"));
        viewAdapter.setData(foods);

        purchase_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> lists = viewAdapter.getPurchaseLists();
                Intent intent2 = new Intent(getApplicationContext(), ConfirmDeliverActivity.class);
                intent2.putExtra("lists", lists);
                startActivity(intent2);
            }
        });

    }

    public void init() {


    }
}