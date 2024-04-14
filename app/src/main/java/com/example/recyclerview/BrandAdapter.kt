package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class BrandAdapter(private val list:ArrayList<BrandModel>):RecyclerView.Adapter<BrandAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var title:TextView
        var icon:ImageView
        init {
            title=itemView.findViewById(R.id.title)
            icon=itemView.findViewById(R.id.icon)
            itemView.setOnClickListener{
                Toast.makeText(itemView.context,list[adapterPosition].title,Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val i = LayoutInflater.from(parent.context).inflate(R.layout.brand_item_layout,parent,false)
        return ViewHolder(i)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text=list[position].title
        holder.icon.setImageResource(list[position].icon)
    }
}