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
import android.widget.Toast;

import com.example.sangrok_delivery.adapter.FoodAdapter;
import com.example.sangrok_delivery.data.DeliveryInfo;
import com.example.sangrok_delivery.data.Food;

import java.util.ArrayList;
import java.util.List;

public class DeliverySelectionActivity extends AppCompatActivity {


    private ImageButton delivery;
    private ImageButton home;

    private TextView where;
    private TextView endtime;
    private TextView destination;
    private TextView menus;
    private TextView message;

    private Button approveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_selection);

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
                "주문시간 :2021-12-10 17:50", "조심히와주세요~",
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

        where = findViewById(R.id.where_selection);
        endtime = findViewById(R.id.endtime_selection);
        destination = findViewById(R.id.destination_selection);
        menus = findViewById(R.id.menus_selection);
        message = findViewById(R.id.message_selection);

        where.setText(testList.get(index).getWhere());
        endtime.setText(testList.get(index).getEndtime());
        destination.setText(testList.get(index).getDestination());
        menus.setText(testList.get(index).getMenus());
        message.setText(testList.get(index).getMessage());

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

        approveButton = findViewById(R.id.approve_button);
        approveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "배달 라이더 등록이 되었습니다!.",Toast.LENGTH_LONG).show();
            }
        });

    }


    public void init() {


    }
}