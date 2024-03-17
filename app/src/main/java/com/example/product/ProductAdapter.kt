package com.example.product

import android.content.Intent
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList : ArrayList<ProductData>)
    : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.IVproductImage.setImageResource(currentItem.IVproductImage)
        holder.TVproductName.text = currentItem.TVproductName
        holder.TVproductPrice.text = "RM" + currentItem.TVproductPrice
        holder.TVproductRating.text = currentItem.TVproductRating

        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, SpecificProduct::class.java)

            context.startActivity(intent)
        }
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val CLproduct : ConstraintLayout = itemView.findViewById(R.id.CLproduct)
        val IVproductImage : ImageView = itemView.findViewById(R.id.IVproductImage)
        val TVproductName : TextView = itemView.findViewById(R.id.TVproductName)
        val TVproductPrice : TextView = itemView.findViewById(R.id.TVproductPrice)
        val TVproductRating : TextView = itemView.findViewById(R.id.TVproductRating)
    }
}