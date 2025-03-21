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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp


class CoinFactActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val coinType = intent.getStringExtra("coin_type") ?: "bitcoin"

        setContent {
            CoinFactScreen(coinType = coinType)  // This will display the coin fact
        }
    }
}
// Display a random coin fact
@Composable
fun CoinFactScreen(coinType: String) {
    // I need to add this variable reference of the current activity
    val context = LocalContext.current

    // I want to just use the 2 coins for simplicity
    //If the image is not bitcoin then it will be xrp
    val (coinText, currentCoinImage) = when (coinType) {
        "bitcoin" -> Pair(
            "Bitcoin\nThe first crypto,\nwith the largest \nmarket cap",
            R.drawable.bitcoin
        )
        "xrp" -> Pair(
            "XRP is a fast, and cheap crypto used for cross-border transactions",
            R.drawable.xrp_token
        )
        else -> Pair(
            "Unknown Coin",
           R.drawable.bitcoin
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dark_bg_coinfact_img),
            contentDescription = "Background",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
        // Adding a bit of
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = coinText,
                color = Color.White,
                fontSize = 50.sp,
                modifier = Modifier.padding(bottom = 32.dp)
                    .offset(y = (-50).dp)

            )

            Spacer(modifier = Modifier.height(325.dp))

            // button which will take you back to the main page.

            Button(
                onClick = { (context as? ComponentActivity)?.finish() },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 32.dp)
                    .padding(end = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.button_background_color),
                    contentColor = colorResource(id = R.color.button_text_color)
                )
            ) {
                Text(text = "Go Back")
            }
        }
    }
}


