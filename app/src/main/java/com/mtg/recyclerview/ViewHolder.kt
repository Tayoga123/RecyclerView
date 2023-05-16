package com.mtg.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_view_template, parent, false)) {

    private var imgView: ImageView? = null
    private var txtName: TextView? = null
    private var txtFrom: TextView? = null

    init {
        imgView = itemView.findViewById(R.id.img_item_photo)
        txtName = itemView.findViewById(R.id.tv_item_name)
        txtFrom = itemView.findViewById(R.id.tv_item_from)
    }

    fun bind(data: Hero){
        imgView?.setImageResource(data.photo!!)
        txtName?.setText(data.name)
        txtFrom?.setText(data.from)
    }
}