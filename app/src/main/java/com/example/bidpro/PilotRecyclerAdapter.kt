package com.example.bidpro

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class PilotRecyclerAdapter(private val context: Context, private val pilots: List<PilotData>) :
    RecyclerView.Adapter<PilotRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_pilot_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return pilots.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pilot = pilots[position]
        holder.textFirstName?.text = pilot.firstName
        holder.textLastName?.text = pilot.lastName
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textFirstName = itemView?.findViewById<TextView?>(R.id.textFirstName)
        val textLastName = itemView?.findViewById<TextView?>(R.id.textLastName)
    }

}
