package com.example.taskwebgridcardview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView

class GridViewAdapter(
    private val list: List<GridViewModel>,
    private val context: Context
) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.gridview_item, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.imageViewIV)
        val button = view.findViewById<Button>(R.id.selectButtonBTN)
        val item = list[position]


        imageView.setImageResource(item.image)
        button.text = item.name


        button.setOnClickListener {
            val intent = Intent(context, WebViewActivity::class.java).apply {
                putExtra("url", item.url)
                putExtra("title", item.name)
            }
            context.startActivity(intent)
        }

        return view
    }
}