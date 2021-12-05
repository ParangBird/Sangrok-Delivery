package com.example.sangrok_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sangrok_delivery.adapter.ItemAdapter;
import com.example.sangrok_delivery.adapter.RestaurantAdapter;
import com.example.sangrok_delivery.data.Item;
import com.example.sangrok_delivery.data.Restaurant;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ConfirmDeliverActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter viewAdapter;
    private RecyclerView.LayoutManager viewManager;
    private TextView price_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_deliver);
        ArrayList<Integer> lists = (ArrayList<Integer>)getIntent().getSerializableExtra("lists");
        ArrayList<Item> items = new ArrayList<Item>();
        Log.d("lists", ""+lists.size());
        String[] strs = new String[]{"치즈불닭", "떡볶이", "김밥", "삼겹살김치철판", "숯불삼겹솥밥", "순대국밥"};
        Integer[] prices = new Integer[]{4500, 3000, 2000, 5000, 4800, 5000};

        for(int i=0;i<lists.size();i++){
            if(lists.get(i) != 0){
                items.add(new Item(strs[i],lists.get(i)));
            }
        }

        recyclerView = findViewById(R.id.recyclerView);
        viewManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true);
        viewAdapter = new ItemAdapter(this);
        viewAdapter.setData(items);
        recyclerView.setAdapter(viewAdapter);

        price_tv = findViewById(R.id.total_price);
        int price = 0;
        for(int i=0;i<lists.size();i++){
            if(lists.get(i) != 0){
                price += prices[i] * lists.get(i);
            }
        }

        String str = String.valueOf(price) + "원";
        price_tv.setText(str);

    }
}