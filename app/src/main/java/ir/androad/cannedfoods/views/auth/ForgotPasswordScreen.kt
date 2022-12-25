package ir.androad.cannedfoods.views.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.androad.cannedfoods.components.JetButton
import ir.androad.cannedfoods.components.JetText
import ir.androad.cannedfoods.components.JetTextField
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun ForgotPasswordScreen(
    toLoginScreen: () -> Unit,
    toRecoveryPasswordScreen: () -> Unit
) {

    var email by remember { mutableStateOf("") }

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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "رمزتو گم کردی؟",
                fontWeight = FontWeight.Bold,
                fontSize = 25,
                textAlign = TextAlign.Center,
                color = BlackColor
            )

            Spacer(modifier = Modifier.height(10.dp))

            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "ایمیل یا شماره خودتو وارد کن و رمز یه بار مصرفی که برات میفرستیم رو بعد دریافتش توی صفحه بعدی بزن.",
                fontSize = 16,
                textAlign = TextAlign.Center,
                color = GrayColor
            )

            Spacer(modifier = Modifier.height(70.dp))

            JetTextField(
                onValueChange = { email = it },
                value = email,
                placeholder = "ایمیل خودتو وارد کن",
                singleLine = true,
                maxLines = 1,
                maxLength = 50,
                keyboardType = KeyboardType.Email,
                title = "ایمیل",
                style = TextStyle(
                    color = LighterGrayColor,
                    fontFamily = Yekanbakh
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            JetButton(
                onClick = { toRecoveryPasswordScreen() },
                width = 0,
                text = "دریافت رمز",
            )

            // TODO: Add Return to Login
        }
    }
}

@Preview
@Composable
fun PreviewForgotPasswordScreen() {
    ForgotPasswordScreen(toLoginScreen = { /*TODO*/ }) {

    }
}