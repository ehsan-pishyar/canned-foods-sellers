package ir.androad.cannedfoods.views

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.components.CBStandardTextField
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun SellerDetailsScreen(navController: NavController) {

    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
    val height = 130.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState())
    ) {

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "ثبت نام فروشنده",
                    fontFamily = Yekanbakh,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    color = BlackColor
                )

                Spacer(modifier = Modifier.height(25.dp))

                var title by remember { mutableStateOf("") }
                CBStandardTextField(
                    onValueChange = {
                        title = it
                    },
                    title = "عنوان فروشگاه",
                    placeholder = "عنوان فروشگاه",
                    maxLength = 50,
                    singleLine = true,
                    maxLines = 1,
                    keyboardType = KeyboardType.Text
                )

                Spacer(modifier = Modifier.height(15.dp))

                var description by remember { mutableStateOf("") }
                CBStandardTextField(
                    onValueChange = {
                        description = it
                    },
                    title = "توضیحات فروشگاه",
                    placeholder = "توضیحات فروشگاه",
                    maxLength = 200,
                    singleLine = false,
                    maxLines = 4,
                    keyboardType = KeyboardType.Text,
                    height = height
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "استان",
                    fontFamily = Yekanbakh,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = BlackColor
                )

                Spacer(modifier = Modifier.height(5.dp))

                val stateItems = listOf("تهران", "اصفهان", "شیراز")
                CBStandardTextField(
                    value = selectedIndex,
                    onValueChange = { selectedIndex = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            //This value is used to assign to the DropDown the same width
                            textFieldSize = coordinates.size.toSize()
                        },
                    placeholder = "استان خود را انتخاب نمائید",
                    trailingIcon = {
                        Icon(
                            imageVector = icon,
                            contentDescription = "contentDescription",
                            modifier = Modifier
                                .clickable { expanded = !expanded })
                    }
                )

                Spacer(modifier = Modifier.height(5.dp))

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .offset(x = 10.dp, y = 10.dp)
                        .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
                ) {

                    stateItems.forEach { index ->
                        DropdownMenuItem(onClick = {
                            selectedIndex = index
                            expanded = false
                        }) {
                            Text(text = index)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "شهر",
                    fontFamily = Yekanbakh,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = BlackColor
                )

                Spacer(modifier = Modifier.height(5.dp))

                val cityItems = listOf("تهران", "اسلام آباد", "کرج")
                CBStandardTextField(
                    value = selectedIndex,
                    onValueChange = { selectedIndex = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            //This value is used to assign to the DropDown the same width
                            textFieldSize = coordinates.size.toSize()
                        },
                    placeholder = "شهر خود را انتخاب نمائید",
                    trailingIcon = {
                        Icon(
                            imageVector = icon,
                            contentDescription = "contentDescription",
                            modifier = Modifier
                                .clickable { expanded = !expanded })
                    }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .offset(x = 10.dp, y = 10.dp)
                ) {

                    cityItems.forEach { index ->
                        DropdownMenuItem(onClick = {
                            selectedIndex = index
                            expanded = false
                        }) {
                            Text(text = index)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "دسته بندی فروشگاه",
                    fontFamily = Yekanbakh,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = BlackColor
                )

                Spacer(modifier = Modifier.height(5.dp))

                val sellerCategoryItems = listOf("رستوران", "میوه فروشی", "شیرینی فروشی")
                CBStandardTextField(
                    value = selectedIndex,
                    onValueChange = { selectedIndex = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            //This value is used to assign to the DropDown the same width
                            textFieldSize = coordinates.size.toSize()
                        },
                    placeholder = "دسته بندی فروشگاه خود را انتخاب نمائید",
                    trailingIcon = {
                        Icon(
                            imageVector = icon,
                            contentDescription = "contentDescription",
                            modifier = Modifier
                                .clickable { expanded = !expanded })
                    }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .offset(x = 10.dp, y = 10.dp)
                ) {

                    sellerCategoryItems.forEach { index ->
                        DropdownMenuItem(onClick = {
                            selectedIndex = index
                            expanded = false
                        }) {
                            Text(text = index)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "نوع فروشگاه",
                    fontFamily = Yekanbakh,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = BlackColor
                )

                Spacer(modifier = Modifier.height(5.dp))

                val resultCategoryItems = listOf("فست فود", "کافی شاپ", "ایرانی")
                CBStandardTextField(
                    value = selectedIndex,
                    onValueChange = { selectedIndex = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            //This value is used to assign to the DropDown the same width
                            textFieldSize = coordinates.size.toSize()
                        },
                    placeholder = "نوع فروشگاه خود را انتخاب نمائید",
                    trailingIcon = {
                        Icon(
                            imageVector = icon,
                            contentDescription = "contentDescription",
                            modifier = Modifier
                                .clickable { expanded = !expanded })
                    }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .offset(x = 10.dp, y = 10.dp)
                ) {

                    resultCategoryItems.forEach { index->
                        DropdownMenuItem(onClick = {
                            selectedIndex = index
                            expanded = false
                        }) {
                            Text(text = index)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "دسته بندی محصولات",
                    fontFamily = Yekanbakh,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = BlackColor
                )

                Spacer(modifier = Modifier.height(5.dp))

                val foodCategoryItems = listOf("پیتزا", "کباب", "ساندیچ")
                CBStandardTextField(
                    value = selectedIndex,
                    onValueChange = { selectedIndex = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            //This value is used to assign to the DropDown the same width
                            textFieldSize = coordinates.size.toSize()
                        },
                    placeholder = "دسته بندی محصولات خود را انتخاب نمائید",
                    trailingIcon = {
                        Icon(
                            imageVector = icon,
                            contentDescription = "contentDescription",
                            modifier = Modifier
                                .clickable { expanded = !expanded })
                    }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .offset(x = 10.dp, y = 10.dp)
                ) {

                    foodCategoryItems.forEach { index ->
                        DropdownMenuItem(onClick = {
                            selectedIndex = index
                            expanded = false
                        }) {
                            Text(text = index)
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        modifier = Modifier
                            .width(150.dp)
                    ) {

                        var deliveryFee by remember { mutableStateOf(0L) }
                        CBStandardTextField(
                            onValueChange = {
                                deliveryFee = it.toLong()
                            },
                            title = "هزینه ارسال",
                            placeholder = "10000",
                            maxLength = 40,
                            singleLine = true,
                            maxLines = 1,
                            keyboardType = KeyboardType.Number
                        )
                    }

                    Column(
                        modifier = Modifier
                            .width(150.dp)
                    ) {

                        var deliveryDuration by remember { mutableStateOf(0) }
                        CBStandardTextField(
                            onValueChange = {
                                deliveryDuration = it.toInt()
                            },
                            title = "مدت زمان ارسال",
                            placeholder = "7",
                            maxLength = 40,
                            singleLine = true,
                            maxLines = 1,
                            keyboardType = KeyboardType.Number
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                var phoneNumber by remember { mutableStateOf("") }
                CBStandardTextField(
                    onValueChange = {
                        phoneNumber = it
                    },
                    title = "شماره تماس",
                    placeholder = "09123456789",
                    maxLength = 11,
                    singleLine = true,
                    maxLines = 1,
                    keyboardType = KeyboardType.Number
                )
            }
        }
    }
}

@Composable
@Preview
fun SellerDetailsScreenPreview() {
    SellerDetailsScreen(navController = NavController(LocalContext.current))
}