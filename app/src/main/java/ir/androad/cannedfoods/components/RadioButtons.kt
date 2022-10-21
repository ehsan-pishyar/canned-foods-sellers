package ir.androad.cannedfoods.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.androad.cannedfoods.ui.theme.LighterGrayColor
import ir.androad.cannedfoods.ui.theme.PrimaryColor
import ir.androad.cannedfoods.ui.theme.Yekanbakh

@Composable
fun RadioButton(text: String, selectedValue: String, onClickListener: (String) -> Unit) {
    Row(Modifier
        .fillMaxWidth()
        .selectable(
            selected = (text == selectedValue),
            onClick = {
                onClickListener(text)
            }
        )
        .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = (text == selectedValue),
            onClick = {
                onClickListener(text)
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = PrimaryColor,
                unselectedColor = LighterGrayColor
            )
        )
        Text(
            text = text,
            fontFamily = Yekanbakh,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
    }
}