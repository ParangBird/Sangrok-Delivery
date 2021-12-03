package com.example.sangrok_delivery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected ImageView itemImage;
        protected TextView itemTitle;
        protected TextView itemDetail;
        public MyViewHolder(View itemView) {
            super(itemView);
             itemImage = itemView.findViewById(R.id.item_image);
             itemTitle = itemView.findViewById(R.id.item_title);
             itemDetail = itemView.findViewById(R.id.item_detail);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_layout, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.itemImage.setImageResource(R.drawable.baseline_account_circle_black_24dp);
        holder.itemTitle.setText("타이틀입니다");
        holder.itemDetail.setText("세부사항 입니다");
    }
    @Override
    public int getItemCount() {
        return 5;
    }
}
