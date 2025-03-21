package com.example.code_assignment_one

/* This file is to use a composable that shows a random
coin fact, I plan to make this a new screen in the app,
and I hope to have it so when the coin is clicked on the
new screen will show, I need to update  the xml  declare
the new activity so the app knows it exists.
 */


import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

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
    // I need to add this variable reference of the current activity
      val activity = LocalActivity.current


     // Adding a bit of
      Column(
          modifier = Modifier
              .fillMaxSize()
              .padding(14.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center) {
          Text(text = "Coin Fact")

          Spacer(modifier = Modifier.height(20.dp))

    // button which will take you back to the main page.

          Button(
              onClick = { activity?.finish() },
              modifier = Modifier.padding(top=16.dp)
          ){
              Text(text = "Go Back")
          }
      }





  }
