package ir.androad.cannedfoods.views.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.androad.cannedfoods.components.CBStandardTextField
import ir.androad.cannedfoods.ui.theme.*
import ir.androad.cannedfoods.viewmodels.ForgotPasswordViewModel

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
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "رمزتو گم کردی؟",
                fontFamily = Yekanbakh,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                color = BlackColor
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "ایمیل یا شماره خودتو وارد کن و رمز یه بار مصرفی که برات میفرستیم رو بعد دریافتش توی صفحه بعدی بزن.",
                fontFamily = Yekanbakh,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = GrayColor
            )

            Spacer(modifier = Modifier.height(70.dp))

            CBStandardTextField(
                onValueChange = { email = it },
                value = email,
                placeholder = "ایمیل خودتو وارد کن",
                maxLength = 100,
                singleLine = true,
                maxLines = 1,
                keyboardType = KeyboardType.Email,
                title = "ایمیل",
                style = TextStyle(
                    color = LighterGrayColor,
                    fontFamily = Yekanbakh
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

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
                    text = "دریافت رمز",
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

@Preview
@Composable
fun PreviewForgotPasswordScreen() {
    ForgotPasswordScreen(toLoginScreen = { /*TODO*/ }) {

    }
}