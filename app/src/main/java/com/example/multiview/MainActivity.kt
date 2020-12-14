package com.example.multiview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        //val childList = generateChildList(5)
        val parentList = generateParentList(30)
        val parentRecyclerView : RecyclerView = findViewById(R.id.parent_recycler_view)

        parentRecyclerView.adapter = ParentAdapter(parentList)
        parentRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
    }

    private fun generateChildList(size: Int): List<ChildItem> {

        val list = ArrayList<ChildItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_snowflake
                else -> R.drawable.ic_airplane
            }

            val item = ChildItem(drawable)
            list += item
        }
        return list
    }

    private fun generateParentList(size : Int) : List<ParentItem> {
        val list = ArrayList<ParentItem>()

        for (i in 0 until size) {
            list.add(ParentItem(generateChildList(10)))
        }
        return list
    }
}