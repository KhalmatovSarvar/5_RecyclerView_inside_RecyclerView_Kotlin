package com.example.a5_recyclerview_inside_recyclerview_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a5_recyclerview_inside_recyclerview_kotlin.adapter.CustomAdapter
import com.example.a5_recyclerview_inside_recyclerview_kotlin.model.Member
import com.example.a5_recyclerview_inside_recyclerview_kotlin.model.SubMember

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun initViews() {
        val context: Context = this
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(this, members)
        recyclerView.adapter = adapter

    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..29) {
            if (i == 1 || i == 10) {
                members.add(Member("Sarvar" + i, "Khalmatov" + i, prepareSubMembers()))
            } else {
                members.add(Member("Sarvar" + i, "Khalmatov" + i, java.util.ArrayList<SubMember>()))
            }
        }
        return members
    }

    private fun prepareSubMembers(): List<SubMember> {
        val members = ArrayList<SubMember>()
        for (i in 0..4) {
            members.add(SubMember("This is a sub list"))
        }
        return members
    }
}