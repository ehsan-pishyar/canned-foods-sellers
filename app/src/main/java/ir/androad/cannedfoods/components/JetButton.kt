package ir.androad.cannedfoods.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.androad.cannedfoods.ui.theme.PrimaryColor

@Composable
fun JetButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    width: Int = 200,
    height: Int = 55,
    color: ButtonColors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor),
    shape: Shape = RoundedCornerShape(12.dp),
    text: String,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.Normal,
    textColor: Color = Color.White

    ) {

    Button(
        onClick = { onClick() },
        modifier = if (width > 0) {
            modifier.width(width.dp).height(height.dp)
        } else {
            modifier.fillMaxWidth().height(height.dp)
        },
        colors = color,
        shape = shape,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {
        JetText(
            text = text,
            fontSize = fontSize,
            fontWeight = fontWeight,
            color = textColor
        )
    }
}