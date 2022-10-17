package ir.androad.cannedfoods.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.androad.cannedfoods.ui.theme.*
import ir.androad.cannedfoods.R

@Composable
fun SplashScreen(navController: NavController) {
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
    ) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "")

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(40.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .padding(30.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "کند فود",
                            fontFamily = Yekanbakh,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Medium,
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            color = PrimaryColor
                        )

                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "فروشندگان",
                            fontFamily = Yekanbakh,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center,
                            color = BlackColor
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "می خوای فروشنده توی کند فود باشی، فروشگاه خودتو ثبت کنی و درآمد داشته باشی؟ پس از اینجا شروع کن. فروشگاه، رستوران یا کافه خودتو ثبت کن.",
                            fontFamily = Yekanbakh,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            color = LightGrayColor
                        )

                        Spacer(modifier = Modifier.height(50.dp))

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .width(200.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor),
                            shape = RoundedCornerShape(12.dp),
                            elevation = ButtonDefaults.elevation(
                                defaultElevation = 0.dp,
                                pressedElevation = 0.dp,
                                disabledElevation = 0.dp
                            )
                        ) {
                            Text(
                                text = "شروع کنیم",
                                fontFamily = Yekanbakh,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                fontStyle = FontStyle.Normal,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    SplashScreen(navController = NavController(LocalContext.current))
}