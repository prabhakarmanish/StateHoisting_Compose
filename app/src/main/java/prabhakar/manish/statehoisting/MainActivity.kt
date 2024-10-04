package prabhakar.manish.statehoisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import prabhakar.manish.statehoisting.ui.theme.StateHoistingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateHoistingTheme {
                navigation()
            }
        }
    }
}

@Composable
fun navigation() {
    var count = rememberSaveable { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        firstline(count)
        clickbutton(count)
        IncrementVIewer(count)
    }
}

@Composable
fun firstline(count: MutableState<Int>) {
    Text(text = "You have clicked ${count.value} times")
}

@Composable
fun clickbutton(count: MutableState<Int>) {
    Button(onClick = { count.value++ }, modifier = Modifier.padding(top = 20.dp)) {
        Text(text = "Increment")
    }
}

@Composable
fun IncrementVIewer(count: MutableState<Int>) {
    Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(top = 30.dp)) {

        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically)
        {
            Image(
                imageVector = Icons.Default.Favorite,
                contentDescription = "",
                modifier = Modifier.padding(4.dp)
            )
            Text(text = "Message sent so far: ${count.value}")
        }
    }
}

