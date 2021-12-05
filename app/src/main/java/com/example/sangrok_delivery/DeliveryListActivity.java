package com.example.sangrok_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sangrok_delivery.adapter.FoodAdapter;
import com.example.sangrok_delivery.data.DeliveryInfo;
import com.example.sangrok_delivery.data.Food;

import java.util.ArrayList;
import java.util.List;

public class DeliveryListActivity extends AppCompatActivity {


    private ImageButton delivery;
    private ImageButton home;
    private LinearLayout item1;
    private LinearLayout item2;
    private LinearLayout item3;
    private LinearLayout item4;
    private LinearLayout item5;
    private LinearLayout item6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_list);

        Intent data = getIntent();
        int index = data.getIntExtra("index", 1) - 1;

        List<DeliveryInfo> testList = new ArrayList<>();
        testList.add(new DeliveryInfo("기숙사식당",
                "주문시간 : 2021-12-10 17:44", "빨리와주세요",
                "돈치퐁 2개", "배달장소 : 원흥관 E259"));
        testList.add(new DeliveryInfo("기숙사식당",
                "주문시간 :2021-12-10 17:48", "똑똑해주세요!!",
                "돈치퐁 외 3개", "배달장소 : 신공학관 3182"));
        testList.add(new DeliveryInfo("상록원",
                "주문시간 :2021-12-10 17:49", "조심히와주세요~",
                "김치철판 외 2개", "배달장소 : 신공학관 3층(알파실)"));
        testList.add(new DeliveryInfo("상록원",
                "주문시간 :2021-12-10 17:51", "조심히와주세요~",
                "김치철판 외 5개", "배달장소 : 신공학관 206"));
        testList.add(new DeliveryInfo("그루터기",
                "주문시간 :2021-12-10 17:51", "조심히와주세요~",
                "김치철판 외 3개", "배달장소 : 혜화관 207-510"));
        testList.add(new DeliveryInfo("그루터기",
                "주문시간 :2021-12-10 17:51", "조심히와주세요~",
                "김치철판 외 4개", "배달장소 : 혜화관 207-510"));

        item1 = findViewById(R.id.delivery1);
        item2 = findViewById(R.id.delivery2);
        item3 = findViewById(R.id.delivery3);
        item4 = findViewById(R.id.delivery4);
        item5 = findViewById(R.id.delivery5);
        item6 = findViewById(R.id.delivery6);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), DeliverySelectionActivity.class);
                intent2.putExtra("index",1);
                startActivity(intent2);
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), DeliverySelectionActivity.class);
                intent2.putExtra("index",2);
                startActivity(intent2);
            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), DeliverySelectionActivity.class);
                intent2.putExtra("index",3);
                startActivity(intent2);
            }
        });
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), DeliverySelectionActivity.class);
                intent2.putExtra("index",4);
                startActivity(intent2);
            }
        });
        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), DeliverySelectionActivity.class);
                intent2.putExtra("index",5);
                startActivity(intent2);
            }
        });
        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), DeliverySelectionActivity.class);
                intent2.putExtra("index",6);
                startActivity(intent2);
            }
        });

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

    public void init() {


    }

}