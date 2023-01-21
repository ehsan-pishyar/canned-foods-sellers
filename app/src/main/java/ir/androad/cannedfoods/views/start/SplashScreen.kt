package ir.androad.cannedfoods.views.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.ui.theme.BackgroundColor
import ir.androad.cannedfoods.viewmodels.SplashScreenViewModel

@Composable
fun SplashScreen(
    toOnBoardingScreen: () -> Unit,
    toLoginScreen: () -> Unit,
    toDashboardScreen: () -> Unit,
    viewModel: SplashScreenViewModel = hiltViewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(painter = painterResource(id = R.mipmap.ic_launcher), contentDescription = "logo")

        }
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen(
        toOnBoardingScreen = { /*TODO*/ },
        toLoginScreen = { /*TODO*/ },
        toDashboardScreen = { /*TODO*/ })
}