package com.sagalang.loginregisterforgotpassworddemo

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val userList : ArrayList<User>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = userList[position]

        holder.username.text = currentitem.username
        holder.email.text = currentitem.email
    }

    override fun getItemCount(): Int {

        return userList.size

    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(ItemView){

        val username : TextView = itemView.findViewById(R.id.tv_username)
        val email : TextView = itemView.findViewById(R.id.tv_email)
    }
}