package com.example.sangrok_delivery.slider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sangrok_delivery.R
import com.example.sangrok_delivery.data.DeliveryInfo

class CardStackAdapter(val context : Context, val items : List<DeliveryInfo>) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardStackAdapter.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: CardStackAdapter.ViewHolder, position: Int) {
        holder.binding(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val where = itemView.findViewById<TextView>(R.id.where);
        val endtime = itemView.findViewById<TextView>(R.id.endtime);
        val message = itemView.findViewById<TextView>(R.id.message);
        val menus = itemView.findViewById<TextView>(R.id.menus);
        val destination = itemView.findViewById<TextView>(R.id.destination);


        fun binding(data : DeliveryInfo) {
            where.text = data.where
            endtime.text = data.endtime
            message.text = data.message
            menus.text = data.menus
            destination.text = data.destination
        }

    }

}