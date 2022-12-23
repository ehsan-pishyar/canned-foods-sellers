package ir.androad.cannedfoods.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import ir.androad.cannedfoods.ui.theme.BlackColor
import ir.androad.cannedfoods.ui.theme.Yekanbakh

@Composable
fun StandardText(
    modifier: Modifier = Modifier,
    text: String = "",
    fontSize: Int = 14,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = BlackColor,
    lineHeight: TextUnit = 1.8.em,
    textAlign: TextAlign = TextAlign.Justify,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Visible
) {

    Text(
        modifier = modifier,
        text = text,
        fontFamily = Yekanbakh,
        fontWeight = fontWeight,
        fontStyle = FontStyle.Normal,
        fontSize = (fontSize).sp,
        color = color,
        lineHeight = lineHeight,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Preview
@Composable
fun PreviewStandardText() {
    StandardText(
        text = "متن تست",
        fontSize = 20,
        textAlign = TextAlign.Center
    )
}