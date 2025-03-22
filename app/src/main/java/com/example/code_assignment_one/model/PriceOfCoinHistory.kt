package com.example.code_assignment_one.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.code_assignment_one.R


//data class to represent the individual
// price history entry add the data for the date and the price
data class PriceOfCoinHistory(
val date: String,
val price: Double
)


// i need to create a recyclerView adapter to bind the data to my view for each item that needs it


//
    class CoinPriceHistoryAdapter(private val priceHistoryList: List<PriceOfCoinHistory>) :
        RecyclerView.Adapter<CoinPriceHistoryAdapter.PriceHistoryViewHolder>() {

        // ViewHolder to hold references to the views
        class PriceHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
            val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        }

        // Create new views (called by the layout manager)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceHistoryViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.coin_price_history, parent, false)
            return PriceHistoryViewHolder(itemView)
        }

        // Bind the data to the views (called by the layout manager)
        override fun onBindViewHolder(holder: PriceHistoryViewHolder, position: Int) {
            val currentItem = priceHistoryList[position]
            holder.dateTextView.text = currentItem.date
            holder.priceTextView.text = currentItem.price.toString()
        }

        // Return the size of the data list
        override fun getItemCount() = priceHistoryList.size
    }



