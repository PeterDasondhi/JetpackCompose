package com.abhay.basiccomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhay.basiccomposeapp.ui.theme.BasicComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeAppTheme {
                // A surface container using the 'background' color from the theme
                CreateProfileCardView()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CreateProfileCardView()
}

@Composable
fun CreateProfileCardView() {

    val buttonClickedState = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .width(500.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = MaterialTheme.colorScheme.background
        ) {
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(390.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                )
            ) {

                CreateProfileImageView()
                Divider()
                ShowProfileDetails()
//                ShowItemList()
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Button(onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    }) {
                        Text(
                            "Portfolio",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                    }
                }
                if (buttonClickedState.value){
                    Content()
                }else {
                    Box {

                    }
                }
            }
        }
    }
}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)
    ) {

        Surface(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            border = BorderStroke(0.5.dp, Color.LightGray),
        ) {

            Protfolio(data = listOf("Project 1", "Project 2", "Project 3", "Project 4"))

        }

    }
}

@Composable
fun Protfolio(data: List<String>) {

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(data.size) { index ->
            Text(
                text = data[index],
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )
        }

    }

}

@Composable
private fun ShowProfileDetails() {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {

        Text(
            text = "Name : Abhay",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )

        Text(
            text = "Android Compose Programmer",
            style = MaterialTheme.typography.titleSmall,
            color = Color.Black
        )

        Text(
            text = "@abhaykumardasondhi@gmail.com",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )

    }
}

@Composable
fun CreateProfileImageView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = CircleShape,
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(5.dp),
            border = BorderStroke(0.5.dp, Color.LightGray),
            shadowElevation = 4.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
        ) {

            Image(
                painter = painterResource(id = R.drawable.photo),
                contentDescription = "Profile Image"
            )
        }
    }
}
