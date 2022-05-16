package com.agh.mymci

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val list: Array<String>): RecyclerView.Adapter<ListAdapter.ListAdapterViewHolder>() {


    class ListAdapterViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView) {
        val text : TextView = itemView.findViewById(R.id.textView)
        val btn : Button = itemView.findViewById(R.id.button2)

    }

    private lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterViewHolder {

        context=parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.alertdialog, parent, false)
        return ListAdapterViewHolder(view)

    }

    override fun onBindViewHolder(holder: ListAdapterViewHolder, position: Int) {
        holder.text.text =  list.get(position)

        holder.btn.setOnClickListener {

            Toast.makeText(context,list.get(position), Toast.LENGTH_SHORT).show()

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}



