package com.example.coinclickerapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.code_assignment_one.CoinFactActivity
import com.example.code_assignment_one.R



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinClickerApp() // call this function to the preview.
        }
    }
}




@Composable
fun CoinClickerApp() {
    //  value you want to store in that "state" to be read first, and is changeable.(xrp token)
    var currentCoinImageId by remember { mutableStateOf<Int>(R.drawable.xrp_token) }


    /* this is meant to swap the coins, I had some difficulties with this portion, but seems
     to work. I did want the images to grow when clicked, and I had it sort of working but
     not its more simple*/

// To launch activities in Compose we use the current context using LocalContext.
    val context = LocalContext.current


    CoinClickerScreen(
        currentCoinImageId = currentCoinImageId,
        onCoinClicked = {
            val intent = Intent(context, CoinFactActivity::class.java)
            context.startActivity(intent)
        },

        //this is a function inside a composable
        onNextCoinClicked = {
            //To change to the next image, swap between two images.
            currentCoinImageId = if (currentCoinImageId == R.drawable.xrp_token) {
                R.drawable.bitcoin // R.drawable accesses the images in res folder.
            } else {
                R.drawable.xrp_token
            }// I would like to add a larger number of coins,
        // not just the 2 so I will need to think of a plan for this.
        }
    )
}


//Note: when using unit it means it will do something but wont return anything

@Composable
fun CoinClickerScreen( // function, that controls what happens when things are clicked
    currentCoinImageId: Int, // the coin image Id is kept track of as an Int value
    onCoinClicked: () -> Unit, // I want to make the coin grow... but having issues
    onNextCoinClicked: () -> Unit, // I want to change which coin is presented
    modifier: Modifier = Modifier //this is good practice, allows for modifying
) {
    Box( // a box is like it sounds, you can keep things inside of it this helps control the UI
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black)) // Set black background of the box
    ) {
        // Fullscreen Background Image (This did not fit properly so I set to fit, and used a black background
        Image(
            painter = painterResource(R.drawable.rocket_background), //background image
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )

        // Bottom container for the coin and button (takes up only a small portion of the bottom)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween // needed space between bottom elements
        ) {
            Image(
                painter = painterResource(currentCoinImageId),
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .align(Alignment.CenterVertically) // Center image vertically
                    .clickable { onCoinClicked() },
                contentScale = ContentScale.Crop // how to tell the content inside the container to act
            )



            // "Next Coin" Button (placed on the right)
            Button(
                onClick = onNextCoinClicked,
                modifier = Modifier
                    .align(Alignment.CenterVertically) // Center button vertically
                    .padding(end = 25.dp), // Padding between the button and the image
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.button_background_color), // Light Green color from colors.xml
                    contentColor = colorResource(id = R.color.button_text_color) // White text color from colors.xml

                )
            ) {
                Text(text = "Next Coin")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoinClickerApp()
}
