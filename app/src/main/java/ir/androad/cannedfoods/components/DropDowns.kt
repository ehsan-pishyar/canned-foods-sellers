package ir.androad.cannedfoods.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun StandardDropdown(
    title: String,
    modifier: Modifier = Modifier,
    items: List<String> = ArrayList(),
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf("") }
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
    val text = selectedIndex.ifEmpty { "انتخاب کنید ..." }

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {

            Text(
                modifier = modifier
                    .fillMaxWidth(),
                text = title,
                fontFamily = Yekanbakh,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = BlackColor
            )

            Text(text = "Test")

            Spacer(modifier = Modifier.height(5.dp))

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = modifier.fillMaxWidth()
            ) {

                items.forEach { index ->
                    DropdownMenuItem(onClick = {
                        selectedIndex = index
                        expanded = false
                    }) {
                        Text(text = index)
                    }
                }
            }
        }



        TextButton(
            onClick = {expanded = true},
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.White
            )
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (selectedIndex.isEmpty()) {
                    Text(
                        text = text,
                        fontFamily = Yekanbakh,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Normal,
                        color = LightGrayColor
                    )
                    Icon(
                        imageVector = icon,
                        contentDescription = ""
                    )
                } else {
                    Text(
                        text = selectedIndex,
                        fontFamily = Yekanbakh,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Normal,
                        color = BlackColor
                    )
                    Icon(
                        imageVector = icon,
                        contentDescription = ""
                    )
                }
            }
        }


    }
}

@Composable
@Preview
fun PreviewStandardDropdown() {
    StandardDropdown(
        title = "null",
        items = listOf("Tehran", "Esfahan", "Shiraz"),
    )
}


@SuppressLint("UnrememberedMutableState")
@Composable
fun StandardDialog(
    title: String,
    modifier: Modifier = Modifier,
    items: List<String> = ArrayList(),
    dialogTitle: String
) {
    var selectedIndex by remember { mutableStateOf("") }
    val text = selectedIndex.ifEmpty { "انتخاب کنید ..." }
    var openDialog by remember{ mutableStateOf(false) }
    var dialogSelectedIndex = mutableStateOf(0)

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {

            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                fontFamily = Yekanbakh,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = BlackColor,
                text = title
            )

            Spacer(modifier = Modifier.height(5.dp))

            TextButton(
                onClick = {
                    openDialog = true
                },
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.White
                )
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (selectedIndex.isEmpty()) {
                        Text(
                            text = text,
                            fontFamily = Yekanbakh,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            color = LightGrayColor
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = "",
                            tint = PrimaryColor
                        )
                    } else {
                        Text(
                            text = selectedIndex,
                            fontFamily = Yekanbakh,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            color = BlackColor
                        )
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = "",
                            tint = PrimaryColor
                        )
                    }
                }
            }

            if (openDialog) {
                Dialog(
                    onDismissRequest = { openDialog = false },
                ) {

                    Surface(
                        modifier = modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp)
                    ) {

                        Column(
                            modifier = modifier
                                .padding(20.dp)
                        ) {

                            Text(
                                text = dialogTitle,
                                fontSize = 15.sp,
                                fontFamily = Yekanbakh,
                                fontWeight = FontWeight.SemiBold,
                                color = LightGrayColor
                            )

                            Spacer(modifier = modifier.height(10.dp))

                            Divider(
                                modifier = modifier.fillMaxWidth(),
                                color = LighterGrayColor,
                                thickness = 1.dp
                            )

                            Spacer(modifier = modifier.height(20.dp))

                            Box(
                                modifier = modifier
                                    .height(300.dp)
                            ) {
                                LazyColumn {
                                    items(items.size) { item ->
                                        RadioButton(items[item], items[dialogSelectedIndex.value]) { selectedValue ->
                                            dialogSelectedIndex.value = items.indexOf(selectedValue)
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = modifier.height(50.dp))

                            Button(
                                onClick = {
                                    selectedIndex = items[dialogSelectedIndex.value]
                                    openDialog = false
                                },
                                shape = RoundedCornerShape(40.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = PrimaryColor,
                                    contentColor = Color.White
                                ),
                                modifier = modifier
                                    .fillMaxWidth()
                                    .align(Alignment.CenterHorizontally)
                                    .height(45.dp)
                            ) {
                                Text(
                                    text = "انتخاب",
                                    fontSize = 15.sp,
                                    fontFamily = Yekanbakh,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewStandardDialog() {
    StandardDialog(
        title = "استان",
        items = listOf("تهران", "اصفهان", "شیراز"),
        dialogTitle = "انتخاب استان"
    )
}