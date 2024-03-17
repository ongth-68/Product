package com.example.product

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private val soldList : ArrayList<SoldData>)
    : RecyclerView.Adapter<HistoryAdapter.HistoryHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.history_layout, parent, false)
        return HistoryHolder(itemView)
    }

    override fun getItemCount(): Int {
        return soldList.size
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val currentItem = soldList[position]
        holder.ivItem.setImageResource(currentItem.Product.IVproductImage)
        holder.tvItem.text = currentItem.Product.TVproductName
        String.format("%s %d", "Amount:", currentItem.SoldAmount).also { holder.tvAmount.text = it }
        String.format("%s %s", "Date:", currentItem.Date.toString()).also { holder.tvAmount.text = it }

        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, SpecificProduct::class.java)

            context.startActivity(intent)
        }
    }

    class HistoryHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val ivItem : ImageView = itemView.findViewById(R.id.ivItem)
        val tvItem : TextView = itemView.findViewById(R.id.tvItem)
        val tvAmount : TextView = itemView.findViewById(R.id.tvAmount)
        val tvDate : TextView = itemView.findViewById(R.id.tvDate)
    }
}