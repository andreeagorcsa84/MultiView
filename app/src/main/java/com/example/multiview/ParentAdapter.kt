package com.example.multiview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ParentAdapter(private val parentList: List<ParentItem>) : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        // turns XML files into View-objects
        val itemView = LayoutInflater.from(parent.context).inflate((R.layout.parent_item), parent, false)
        return ParentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {

        val parentCurrentItem = parentList[position]
        val childLayoutManager = LinearLayoutManager(holder.childRecyclerView?.context, LinearLayoutManager.HORIZONTAL, false)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.childRecyclerView?.apply {
            layoutManager = childLayoutManager
            adapter = ChildAdapter(parentCurrentItem.items)
            setRecycledViewPool(viewPool)
        }
    }

    override fun getItemCount(): Int {
        return parentList.size
    }

    class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val childRecyclerView : RecyclerView? = itemView.findViewById(R.id.child_recycler_view)
    }
}