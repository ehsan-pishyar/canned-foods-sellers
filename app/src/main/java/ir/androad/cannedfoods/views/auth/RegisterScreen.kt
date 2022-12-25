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
import ir.androad.cannedfoods.components.JetButton
import ir.androad.cannedfoods.components.JetText
import ir.androad.cannedfoods.components.JetTextField
import ir.androad.cannedfoods.components.addSocialButtons
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun RegisterScreen(
    toLoginScreen: () -> Unit,
    toDashboardScreen: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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
                text = "فروشنده شو!",
                fontWeight = FontWeight.Bold,
                fontSize = 25,
                textAlign = TextAlign.Center,
                color = BlackColor
            )

            Spacer(modifier = Modifier.height(10.dp))

            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "منتظرت بودیم رفیق",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = GrayColor
            )

            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "همین الان فروشگاهتو ثبت کن",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = GrayColor
            )

            Spacer(modifier = Modifier.height(30.dp))

            JetTextField(
                onValueChange = {
                    email = it
                },
                title = "ایمیل",
                placeholder = "ایمیل خودتو وارد کن",
                singleLine = true,
                maxLines = 1,
                maxLength = 50,
                keyboardType = KeyboardType.Email,
                style = TextStyle(
                    color = LighterGrayColor,
                    fontSize = 14.sp,
                    fontFamily = Yekanbakh
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            JetTextField(
                onValueChange = {
                    password = it
                },
                title = "رمز عبور",
                placeholder = "رمز عبورتو وارد کن",
                singleLine = true,
                maxLines = 1,
                maxLength = 50,
                keyboardType = KeyboardType.Password,
                isPasswordToggleDisplayed = true,
                isPasswordVisible = true,
                style = TextStyle(
                    color = LighterGrayColor,
                    fontSize = 14.sp,
                    fontFamily = Yekanbakh
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            JetTextField(
                onValueChange = {
                    confirmPassword = it
                },
                title = "تکرار رمز عبور",
                placeholder = "تکرار رمز عبور",
                singleLine = true,
                maxLines = 1,
                maxLength = 50,
                keyboardType = KeyboardType.Password,
                isPasswordToggleDisplayed = true,
                isPasswordVisible = true,
                style = TextStyle(
                    color = LighterGrayColor,
                    fontSize = 14.sp,
                    fontFamily = Yekanbakh
                )
            )

            Spacer(modifier = Modifier.height(50.dp))

            JetButton(
                onClick = { toDashboardScreen() },
                width = 0,
                text = "ثبت نام",
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
                    text = "یا ثبت نام با شبکه های اجتماعی",
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
                    text = "فروشنده ای؟",
                    fontSize = 14,
                    color = GrayColor
                )

                TextButton(
                    onClick = { toLoginScreen() },
                ) {
                    JetText(
                        modifier = Modifier
                            .wrapContentWidth(),
                        text = "صفحه ورود",
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
fun RegisterScreenPreview() {
    RegisterScreen(toLoginScreen = { /*TODO*/ }) {

    }
}