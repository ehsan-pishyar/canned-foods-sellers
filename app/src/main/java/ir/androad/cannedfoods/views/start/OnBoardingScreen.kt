package ir.androad.cannedfoods.views.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.androad.cannedfoods.ui.theme.*
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.components.JetButton
import ir.androad.cannedfoods.components.JetText
import ir.androad.cannedfoods.viewmodels.SplashScreenViewModel

@Composable
fun OnBoardingScreen(
    toLoginScreen: () -> Unit,
    splashScreenViewModel: SplashScreenViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.onboarding),
                contentDescription = "",
                modifier = Modifier
                    .size(330.dp)
                    .padding(
                        start = 40.dp,
                        top = 40.dp
                    )
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(30.dp)
            ) {

                Column(
                    modifier = Modifier
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    JetText(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "جت فود",
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Medium,
                        fontSize = 25,
                        textAlign = TextAlign.Center,
                        color = PrimaryColor
                    )

                    JetText(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "فروشندگان",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30,
                        textAlign = TextAlign.Center,
                        color = BlackColor
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    JetText(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "می خوای فروشنده توی جت فود باشی، فروشگاه خودتو ثبت کنی و درآمد داشته باشی؟ پس از اینجا شروع کن. فروشگاه، رستوران یا کافه خودتو ثبت کن.",
                        fontWeight = FontWeight.Normal,
                        fontSize = 16,
                        textAlign = TextAlign.Center,
                        color = LightGrayColor,
                        maxLines = 5
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    JetButton(
                        onClick = {
                            splashScreenViewModel.saveOnBoardingState(completed = true)
                            toLoginScreen()
                                  },
                        width = 200,
                        text = "شروع کنیم",
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewOnBoardingScreen() {
    OnBoardingScreen(
        toLoginScreen = {}
    )
}