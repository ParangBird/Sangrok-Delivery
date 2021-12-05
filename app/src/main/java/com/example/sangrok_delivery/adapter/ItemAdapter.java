package com.example.sangrok_delivery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sangrok_delivery.ConfirmDeliverActivity;
import com.example.sangrok_delivery.R;
import com.example.sangrok_delivery.data.Item;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    public class ItemHolder extends RecyclerView.ViewHolder{
        protected TextView no;
        protected TextView menu;
        protected TextView number;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            no = itemView.findViewById(R.id.no);
            menu = itemView.findViewById(R.id.menu);
            number = itemView.findViewById(R.id.number);
        }
    }


    ArrayList<Item> list;
    Context mContext;
    public ItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(ArrayList<Item> lists) {
        this.list = lists;
    }
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        ItemHolder viewHolder = new ItemHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

            holder.no.setText(String.valueOf(position+1));
            holder.menu.setText(list.get(position).getName());
            holder.number.setText(String.valueOf(list.get(position).getNumber()));
    }

    @Override
    public int getItemCount() {
        if(list == null)
            return 0;
        return list.size();
    }


}
