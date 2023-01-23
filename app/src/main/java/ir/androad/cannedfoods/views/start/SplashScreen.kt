package ir.androad.cannedfoods.views.start

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.components.JetText
import ir.androad.cannedfoods.ui.theme.BackgroundColor
import ir.androad.cannedfoods.viewmodels.SplashScreenViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    toOnBoardingScreen: () -> Unit,
    toLoginScreen: () -> Unit,
    toDashboardScreen: () -> Unit,
    viewModel: SplashScreenViewModel = hiltViewModel()
) {

    val isOnBoardingCompleted = viewModel.checkOnBoardingState()
    val isUserLoggedIn = viewModel.checkUserLoginState()

    val scale = remember {
        Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 300,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        if (isOnBoardingCompleted) {
            if (isUserLoggedIn) {
                toDashboardScreen()
            } else {
                toLoginScreen()
            }
        } else {
            toOnBoardingScreen()
        }
    }

    Surface(
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
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(130.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            JetText(text = "جت فود فروشندگان")
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