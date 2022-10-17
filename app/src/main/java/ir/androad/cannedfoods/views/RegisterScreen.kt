package ir.androad.cannedfoods.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.components.CBStandardTextField
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun RegisterScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
    ) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomCenter)
                    .padding(30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "فروشنده شو!",
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
                    text = "منتظرت بودیم رفیق",
                    fontFamily = Yekanbakh,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = GrayColor
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "همین الان فروشگاهتو ثبت کن",
                    fontFamily = Yekanbakh,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = GrayColor
                )

                Spacer(modifier = Modifier.height(30.dp))

                var email by remember { mutableStateOf("") }
                CBStandardTextField(
                    onValueChange = {
                        email = it
                    },
                    placeholder = "ایمیل خودتو وارد کن",
                    maxLength = 100,
                    singleLine = true,
                    maxLines = 1,
                    keyboardType = KeyboardType.Email
                )

                Spacer(modifier = Modifier.height(12.dp))

                var password by remember { mutableStateOf("") }
                CBStandardTextField(
                    onValueChange = {
                        password = it
                    },
                    placeholder = "رمز عبورتو وارد کن",
                    maxLength = 40,
                    singleLine = true,
                    maxLines = 1,
                    keyboardType = KeyboardType.Password,
                    isPasswordToggleDisplayed = true,
                    isPasswordVisible = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                var confirmPassword by remember { mutableStateOf("") }
                CBStandardTextField(
                    onValueChange = {
                        confirmPassword = it
                    },
                    placeholder = "تکرار رمز عبور",
                    maxLength = 40,
                    singleLine = true,
                    maxLines = 1,
                    keyboardType = KeyboardType.Password,
                    isPasswordToggleDisplayed = true,
                    isPasswordVisible = true
                )

                Spacer(modifier = Modifier.height(50.dp))

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
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
                        text = "ثبت نام",
                        fontFamily = Yekanbakh,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Divider(
                        modifier = Modifier
                            .width(70.dp)
                            .height(1.dp)
                            .padding(horizontal = 10.dp),
                        color = LightGrayColor
                    )

                    Text(
                        modifier = Modifier
                            .wrapContentWidth(),
                        text = "یا ثبت نام با شبکه های اجتماعی",
                        fontFamily = Yekanbakh,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = GrayColor
                    )

                    Divider(
                        modifier = Modifier
                            .width(70.dp)
                            .height(1.dp)
                            .padding(horizontal = 10.dp),
                        color = LightGrayColor
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    Button(
                        modifier = Modifier
                            .width(70.dp)
                            .height(50.dp)
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                            disabledElevation = 0.dp
                        )
                    ) {

                        Icon(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                            painter = painterResource(id = R.drawable.icon_google),
                            contentDescription = ""
                        )
                    }

                    Button(
                        modifier = Modifier
                            .width(70.dp)
                            .height(50.dp)
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                            disabledElevation = 0.dp
                        )
                    ) {

                        Icon(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                            painter = painterResource(id = R.drawable.icon_github),
                            contentDescription = ""
                        )
                    }

                    Button(
                        modifier = Modifier
                            .width(70.dp)
                            .height(50.dp)
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                            disabledElevation = 0.dp
                        )
                    ) {

                        Icon(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                            painter = painterResource(id = R.drawable.icon_twitter),
                            contentDescription = ""
                        )
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        modifier = Modifier
                            .wrapContentWidth(),
                        text = "فروشنده ای؟",
                        fontFamily = Yekanbakh,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = GrayColor
                    )

                    TextButton(
                        onClick = { /*TODO*/ },
                    ) {

                        Text(
                            modifier = Modifier
                                .wrapContentWidth(),
                            text = "صفحه ورود",
                            fontFamily = Yekanbakh,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun RegisterScreenPreview() {
    RegisterScreen(navController = NavController(LocalContext.current))
}