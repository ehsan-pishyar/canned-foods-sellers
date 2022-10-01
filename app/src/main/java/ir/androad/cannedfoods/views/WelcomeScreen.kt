package ir.androad.cannedfoods.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.androad.cannedfoods.R

@Composable
fun WelcomeScreen(navController: NavController) {

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_launcher),
                    contentDescription = "Cannedfood Logo",
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Canned Foods",
                    color =  Color.Black,
                    style = MaterialTheme.typography.h1,
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewWelcomeScreen() {
    WelcomeScreen(navController = NavController(LocalContext.current))
}