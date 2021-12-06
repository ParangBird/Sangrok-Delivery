package com.example.sangrok_delivery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sangrok_delivery.data.DeliveryInfo
import com.example.sangrok_delivery.slider.CardStackAdapter
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.CardStackView
import com.yuyakaido.android.cardstackview.Direction

class DeliveryActivity : AppCompatActivity() {

    lateinit var cardStackAdapter : CardStackAdapter
    lateinit var manager : CardStackLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val testList = mutableListOf<DeliveryInfo>()
        testList.add(DeliveryInfo("기숙사식당",
                "주문시간 : 2021-12-10 17:44", "빨리와주세요",
                "돈치퐁 2개", "배달장소 : 원흥관 E259"));
        testList.add(DeliveryInfo("기숙사식당",
                "주문시간 :2021-12-10 17:48", "똑똑해주세요!!",
                "돈치퐁 외 3개", "배달장소 : 신공학관 3182"));
        testList.add(DeliveryInfo("상록원",
                "주문시간 :2021-12-10 17:50", "조심히와주세요~",
                "김치철판 외 2개", "배달장소 : 신공학관 3층(알파실)"));
        testList.add(DeliveryInfo("상록원",
                "주문시간 :2021-12-10 17:51", "조심히와주세요~",
                "김치철판 외 5개", "배달장소 : 신공학관 206"))


        setContentView(R.layout.activity_delivery)

        val cardStackView = findViewById<CardStackView>(R.id.cardStackView)

        manager = CardStackLayoutManager(baseContext, object : CardStackListener {
            override fun onCardDragging(direction: Direction?, ratio: Float) {
                Log.d("Direction", "Dragg d = ${direction}")

            }

            override fun onCardSwiped(direction: Direction?) {
                Log.d("Direction", "Swiped d = ${direction}")
                if(direction == Direction.Right){
                    Log.d("Direction", "Swiped d = ${manager.topPosition}")
                    var info = Intent(this@DeliveryActivity, DeliverySelectionActivity::class.java)
                    info.putExtra("index", manager.topPosition)
                    startActivity(info)
                }else{
                    if(manager.topPosition == 4){
                        var info = Intent(this@DeliveryActivity, DeliveryListActivity::class.java)
                        startActivity(info)
                    }
                }
            }

            override fun onCardRewound() {

            }

            override fun onCardCanceled() {

            }

            override fun onCardAppeared(view: View?, position: Int) {

            }

            override fun onCardDisappeared(view: View?, position: Int) {

            }

        })


        cardStackAdapter = CardStackAdapter(baseContext, testList)
        cardStackView.layoutManager = manager
        cardStackView.adapter = cardStackAdapter

    }

}