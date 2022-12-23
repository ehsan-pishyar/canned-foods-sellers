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
import ir.androad.cannedfoods.components.CBStandardTextField
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun PasswordRecoveryScreen(
    toLoginScreen: () -> Unit,
    toDashboardScreen: () -> Unit
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
                text = "ثبت رمــــــــز",
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
                text = "رمز یه بار مصرفی که دریافت کردی رو توی فیلد پایین وارد کن.",
                fontFamily = Yekanbakh,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = GrayColor
            )

            Spacer(modifier = Modifier.height(70.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                addPasswordRecoveryTextFields()
            }

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
                    text = "ثبت رمز",
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

@Composable
fun RowScope.addPasswordRecoveryTextFields() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        CBStandardTextField(
            onValueChange = {  },
            value = "",
            maxLength = 1,
            singleLine = true,
            maxLines = 1,
            keyboardType = KeyboardType.Number,
            placeholder = "0",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = Yekanbakh,
                fontSize = 20.sp,
                color = LighterGrayColor
            ),
            modifier = Modifier
                .weight(1f)
                .height(80.dp)
                .padding(3.dp)
        )
        CBStandardTextField(
            onValueChange = {  },
            value = "",
            maxLength = 1,
            singleLine = true,
            maxLines = 1,
            keyboardType = KeyboardType.Number,
            placeholder = "0",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = Yekanbakh,
                fontSize = 20.sp,
                color = LighterGrayColor
            ),
            modifier = Modifier
                .weight(1f)
                .height(80.dp)
                .padding(3.dp)
        )
        CBStandardTextField(
            onValueChange = {  },
            value = "",
            maxLength = 1,
            singleLine = true,
            maxLines = 1,
            keyboardType = KeyboardType.Number,
            placeholder = "0",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = Yekanbakh,
                fontSize = 20.sp,
                color = LighterGrayColor
            ),
            modifier = Modifier
                .weight(1f)
                .height(80.dp)
                .padding(3.dp)
        )
        CBStandardTextField(
            onValueChange = {  },
            value = "",
            maxLength = 1,
            singleLine = true,
            maxLines = 1,
            keyboardType = KeyboardType.Number,
            placeholder = "0",
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontFamily = Yekanbakh,
                fontSize = 20.sp,
                color = LighterGrayColor
            ),
            modifier = Modifier
                .weight(1f)
                .height(80.dp)
                .padding(3.dp)
        )
    }
}

@Preview
@Composable
fun PreviewPasswordRecoveryScreen() {
    PasswordRecoveryScreen(toLoginScreen = { /*TODO*/ }) {

    }
}