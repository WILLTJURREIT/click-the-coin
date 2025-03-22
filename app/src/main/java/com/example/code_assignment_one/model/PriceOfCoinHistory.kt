package com.example.code_assignment_one.model

import androidx.recyclerview.widget.RecyclerView


//data class to represent the individual
// price history entry add the data for the date and the price
data class PriceOfCoinHistory(
val date: String,
val price: Double
)


// i need to create a recyclerView adapter to bind the data to my view for each item that needs it


// this will hold references to the views
    class CoinPriceHistoryAdapter(private val priceHistoryList: List<PriceOfCoinHistory>) :
        RecyclerView.Adapter<PriceHistoryAdapter.PriceHistoryViewHolder>() {
    }

