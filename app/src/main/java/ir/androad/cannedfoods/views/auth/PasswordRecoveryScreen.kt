package ir.androad.cannedfoods.views.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.androad.cannedfoods.components.JetButton
import ir.androad.cannedfoods.components.JetText
import ir.androad.cannedfoods.components.addPasswordRecoveryTextFields
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
            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "ثبت رمــــــــز",
                fontSize = 25,
                textAlign = TextAlign.Center,
                color = BlackColor
            )

            Spacer(modifier = Modifier.height(10.dp))

            JetText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "رمز یه بار مصرفی که دریافت کردی رو توی فیلد پایین وارد کن.",
                fontSize = 16,
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

            JetButton(
                onClick = { toDashboardScreen() },
                width = 0,
                text = "ثبت رمز",
            )

            // TODO: Add Return to Login
        }
    }
}

@Preview
@Composable
fun PreviewPasswordRecoveryScreen() {
    PasswordRecoveryScreen(toLoginScreen = { /*TODO*/ }) {

    }
}