package ir.androad.cannedfoods.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.ui.theme.LighterGrayColor
import ir.androad.cannedfoods.ui.theme.Yekanbakh

@Composable
fun RowScope.addSocialButtons(
    toGoogle: () -> Unit,
    toGithub: () -> Unit,
    toTwitter: () -> Unit
) {
    Button(
        modifier = Modifier
            .width(70.dp)
            .height(50.dp),
        onClick = { toGoogle() },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        shape = RoundedCornerShape(8.dp),
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
            .height(50.dp),
        onClick = { toGithub() },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        shape = RoundedCornerShape(8.dp),
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
            .height(50.dp),
        onClick = { toTwitter() },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        shape = RoundedCornerShape(8.dp),
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

@Composable
fun RowScope.addPasswordRecoveryTextFields() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        JetTextField(
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
        JetTextField(
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
        JetTextField(
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
        JetTextField(
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