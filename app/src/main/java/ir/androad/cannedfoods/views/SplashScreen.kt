package ir.androad.cannedfoods.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.ui.theme.BackgroundColor
import ir.androad.cannedfoods.ui.theme.BlackColor
import ir.androad.cannedfoods.ui.theme.Yekanbakh
import ir.androad.cannedfoods.viewmodels.WelcomeViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: WelcomeViewModel
) {

    LaunchedEffect(key1 = false) {
        delay(3000L)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo")

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "کند فـــــــــود",
                fontFamily = Yekanbakh,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 25.sp,
                color = BlackColor
            )
        }
    }
}

@Composable
@Preview
fun PreviewSplashScreen() {
    SplashScreen(navController = NavController(LocalContext.current), viewModel = WelcomeViewModel())
}