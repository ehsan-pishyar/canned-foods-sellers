package ir.androad.cannedfoods.views.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.androad.cannedfoods.components.JetTextField
import ir.androad.cannedfoods.components.JetButton
import ir.androad.cannedfoods.components.JetText
import ir.androad.cannedfoods.components.addSocialButtons
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun LoginScreen(
    toRegisterScreen: () -> Unit,
    toForgotPasswordScreen: () -> Unit,
    toDashboardScreen: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "سلام دوباره!",
                fontWeight = FontWeight.Bold,
                fontSize = 25,
                textAlign = TextAlign.Center,
                color = BlackColor
            )

            Spacer(modifier = Modifier.height(10.dp))

            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "خوش اومـــــدی",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = GrayColor
            )

            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "دلمون برات تنگ شده بود",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = GrayColor
            )

            Spacer(modifier = Modifier.height(30.dp))

            JetTextField(
                onValueChange = {
                    email = it
                },
                value = email,
                placeholder = "ایمیل خودتو وارد کن",
                singleLine = true,
                maxLines = 1,
                maxLength = 50,
                keyboardType = KeyboardType.Email,
                title = "ایمیل",
                style = TextStyle(
                    color = LighterGrayColor,
                    fontFamily = Yekanbakh,
                    fontSize = 14.sp
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            JetTextField(
                onValueChange = { password = it },
                value = password,
                placeholder = "رمز عبورتو وارد کن",
                singleLine = true,
                maxLines = 1,
                maxLength = 50,
                keyboardType = KeyboardType.Password,
                isPasswordToggleDisplayed = true,
                isPasswordVisible = false,
                title = "رمز عبور",
                style = TextStyle(
                    color = LighterGrayColor,
                    fontFamily = Yekanbakh,
                    fontSize = 14.sp
                )
            )

            TextButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { toForgotPasswordScreen() }
            ) {
                JetText(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "رمز عبورتو فراموش کردی؟",
                    textAlign = TextAlign.End,
                    fontSize = 14,
                    color = PrimaryColor
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            JetButton(
                onClick = { toDashboardScreen() },
                width = 0,
                text = "ورود",
            )

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

                JetText(
                    modifier = Modifier
                        .wrapContentWidth(),
                    text = "یا ورود با شبکه های اجتماعی",
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
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                addSocialButtons(
                    toGoogle = {},
                    toGithub = {},
                    toTwitter = {}
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                JetText(
                    modifier = Modifier
                        .wrapContentWidth(),
                    text = "هنوز فروشنده نشدی؟",
                    fontSize = 14,
                    color = GrayColor
                )

                TextButton(
                    onClick = { toRegisterScreen() },
                ) {
                    JetText(
                        modifier = Modifier
                            .wrapContentWidth(),
                        text = "الان ثبت نام کن",
                        fontSize = 14,
                        color = PrimaryColor
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen(toRegisterScreen = { /*TODO*/ }, toForgotPasswordScreen = { /*TODO*/ }) {

    }
}