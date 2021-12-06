package com.example.sangrok_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button button;

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

        //dropdown list
        String[] buildings = {"본관","명진관","과학관","다향관","상록원","법학관","만해관","중앙도서관","사회과학관","경영관",
                "문화관","학술관","혜화관","학림관","계산관","원흥관","신공학관","남산학사","정보문화관","학생회관"};

        Spinner buildingSpinner = findViewById(R.id.building);
        ArrayAdapter<String> sidoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,buildings);
        sidoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        buildingSpinner.setAdapter(sidoAdapter);

        button = findViewById(R.id.finish);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"주문이 완료되었습니다",Toast.LENGTH_LONG).show();
            }
        });
    }
}