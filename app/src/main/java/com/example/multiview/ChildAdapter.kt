package com.example.multiview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ChildAdapter(private val childList: List<ChildItem>) : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        // turns XML files into View-objects
        val itemView = LayoutInflater.from(parent.context).inflate((R.layout.child_item), parent, false)
        return ChildViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {

        val childCurrentItem = childList[position]
        holder.imageView.setImageResource(childCurrentItem.image)
    }

    override fun getItemCount(): Int {

        return childList.size
    }

    class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView : ImageView = itemView.findViewById(R.id.child_image_view)
    }
}