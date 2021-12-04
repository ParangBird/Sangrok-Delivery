package com.example.sangrok_delivery.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sangrok_delivery.R;
import com.example.sangrok_delivery.data.Restaurant;
import com.example.sangrok_delivery.SelectMenuActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyViewHolder> {

    private Context mContext;

    public RestaurantAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected ImageView itemImage;
        protected TextView itemTitle;
        protected TextView itemDetail;
        protected CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
             itemImage = itemView.findViewById(R.id.item_image);
             itemTitle = itemView.findViewById(R.id.item_title);
             itemDetail = itemView.findViewById(R.id.item_detail);
             cardView = itemView.findViewById(R.id.card_view);
        }

    }

    public ArrayList<Restaurant> restaurants;

    public void setData(ArrayList<Restaurant> restaurants){
        this.restaurants = restaurants;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_cardview_layout, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.itemImage.setImageResource(R.drawable.baseline_account_circle_black_24dp);
        holder.itemTitle.setText(restaurants.get(position).getName());
        holder.itemDetail.setText(restaurants.get(position).getLocation());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(mContext.getApplicationContext(), SelectMenuActivity.class);
                intent2.putExtra("restaurant",  restaurants.get(position).getName());
                // intent 넘어가면서 restaurant 이름으로 유저가 선택한 식당 값 보내주기만 하면 됩니다.
                mContext.startActivity(intent2);
            }
        });

    }
    @Override
    public int getItemCount() {


        if(restaurants == null)
            return 0;
        else{
            return restaurants.size();
        }


    }
}
