package com.example.a5_recyclerview_inside_recyclerview_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a5_recyclerview_inside_recyclerview_kotlin.R
import com.example.a5_recyclerview_inside_recyclerview_kotlin.model.SubMember

class CustomSubAdapter(private val context: Context, private val subMembers: List<SubMember>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_sub_view,parent,false)
        return CustomSubViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val status = subMembers[position]
    }

    override fun getItemCount(): Int {
        return subMembers.size
    }
}

class CustomSubViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}
