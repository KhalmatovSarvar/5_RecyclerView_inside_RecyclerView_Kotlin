package com.example.a5_recyclerview_inside_recyclerview_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a5_recyclerview_inside_recyclerview_kotlin.R
import com.example.a5_recyclerview_inside_recyclerview_kotlin.model.Member
import com.example.a5_recyclerview_inside_recyclerview_kotlin.model.SubMember

class CustomAdapter(val context: Context, val members: List<Member>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object{
        private val TYPE_ITEM_VIEW = 0
        private val TYPE_ITEM_LIST = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if(members[position].memberSubs.size>0) TYPE_ITEM_LIST else TYPE_ITEM_VIEW

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM_VIEW){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_view,parent,false)
            return CustomViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_list,parent,false)
            return CustomListHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]
        if(holder is CustomViewHolder){}
        if(holder is CustomListHolder){
            val recyclerViewSub = holder.recyclerViewSub
            recyclerViewSub.layoutManager = GridLayoutManager(context,1)

            val memberSubs = member.memberSubs
            refreshSubAdapter(recyclerViewSub,memberSubs)
        }
    }

    private fun refreshSubAdapter(recyclerviewSub:RecyclerView,subMembers: List<SubMember>) {
        val adapter = CustomSubAdapter(context, subMembers)
        recyclerviewSub.adapter = adapter

    }

    override fun getItemCount(): Int {
        return members.size
    }
}

class CustomListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var recyclerViewSub :RecyclerView
    init{
        recyclerViewSub= itemView.findViewById(R.id.recyclerViewSub)
    }

}

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
