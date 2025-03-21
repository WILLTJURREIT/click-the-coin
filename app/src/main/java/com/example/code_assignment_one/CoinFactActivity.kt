package com.example.code_assignment_one

/* This file is to use a composable that shows a random
coin fact, I plan to make this a new screen in the app,
and I hope to have it so when the coin is clicked on the
new screen will show, I need to update  the xml  declare
the new activity so the app knows it exists.
 */


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


class CoinFactActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
        setContent {
            CoinFactScreen()
        }
    }
// Display a random coin fact
} @Composable
  fun CoinFactScreen() {
    Text(text = "Bitcoin Is the largest crypto coin by market cap!")
}

