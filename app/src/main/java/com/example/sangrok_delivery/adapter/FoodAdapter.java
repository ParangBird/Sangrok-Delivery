package com.example.sangrok_delivery.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sangrok_delivery.R;
import com.example.sangrok_delivery.SelectMenuActivity;
import com.example.sangrok_delivery.data.Food;
import com.example.sangrok_delivery.data.Restaurant;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private Context mContext;
    public FoodAdapter(Context mContext) {
        this.mContext = mContext;
    }
    private ArrayList<Integer> lists = new ArrayList<>();


    public class FoodViewHolder extends RecyclerView.ViewHolder {
        protected TextView menuTitle;
        protected TextView menuPrice;
        protected ImageView plus;
        protected ImageView minus;
        protected TextView menuNumber;
        public FoodViewHolder(View itemView) {
            super(itemView);
            menuTitle = itemView.findViewById(R.id.menu_title);
            menuPrice = itemView.findViewById(R.id.menu_price);
            plus = itemView.findViewById(R.id.plus_button);
            minus = itemView.findViewById(R.id.minus_button);
            menuNumber = itemView.findViewById(R.id.menu_number);
            if(lists.size() == 0) {
                for (int i = 0; i < 6; i++)
                    lists.add(0);
            }
        }
    }

    public ArrayList<Food> foods;
    public void setData(ArrayList<Food> foods){
        this.foods = foods;
    }


    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_cardview_layout, parent, false);

        FoodViewHolder viewHolder = new FoodViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        holder.menuTitle.setText(foods.get(position).getName());
        holder.menuPrice.setText(foods.get(position).getPrice());
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = holder.menuNumber.getText().toString();
                int prev_int = Integer.parseInt(prev);
                if(prev_int <= 8) {
                    holder.menuNumber.setText(String.valueOf(prev_int + 1));
                    lists.set(position, prev_int+1);
                }

            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prev = holder.menuNumber.getText().toString();
                int prev_int = Integer.parseInt(prev);
                if(prev_int >= 1) {
                    holder.menuNumber.setText(String.valueOf(prev_int - 1));
                    lists.set(position, prev_int-1);
                }
            }
        });
    }


    public ArrayList<Integer> getPurchaseLists(){
        return lists;
    }

    @Override
    public int getItemCount() {
        if(foods == null)
            return 0;
        else{
            return foods.size();
        }
    }
}
