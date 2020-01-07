package com.example.bidpro

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FlightRecyclerAdapter (private val context : Context, private val flights: List<FlightData>) :
    RecyclerView.Adapter<FlightRecyclerAdapter.ViewHolder>() {

    private  val layoutInflator = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = layoutInflator.inflate(R.layout.item_flight_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return flights.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flight = flights[position]
        holder.textId?.text = flight.bidTypeId
        holder.textSeat?.text = flight.seat
        holder.textFleet?.text = flight.fleet
        holder.textDomicile?.text = flight.domicile
        holder.textStatus?.text = flight.status
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textId = itemView?.findViewById<TextView?>(R.id.text_id)
        val textSeat = itemView?.findViewById<TextView?>(R.id.text_seat)
        val textFleet = itemView?.findViewById<TextView?>(R.id.text_fleet)
        val textDomicile = itemView?.findViewById<TextView?>(R.id.text_domicile)
        val textStatus = itemView?.findViewById<TextView?>(R.id.text_status)

    }

}
