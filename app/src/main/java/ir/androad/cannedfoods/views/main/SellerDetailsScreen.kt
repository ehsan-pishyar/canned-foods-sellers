package ir.androad.cannedfoods.views.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.androad.cannedfoods.components.JetTextField
import ir.androad.cannedfoods.components.StandardDialog
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun SellerDetailsScreen() {

    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf("") }
    val icon = Icons.Filled.KeyboardArrowDown

    val sellerCategoryItems = listOf("رستوران", "کافه", "میوه فروشی")
    val resultCategoryItems = listOf("فست فود", "کافی شاپ", "ایرانی")
    val foodCategoryItems = listOf("پیتزا", "کباب", "ساندیچ")

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var deliveryFee by remember { mutableStateOf(0L) }
    var deliveryDuration by remember { mutableStateOf(0) }

    var phoneNumber by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState())
    ) {

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

            Spacer(modifier = Modifier.height(30.dp))

            JetTextField(
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

            Spacer(modifier = Modifier.height(20.dp))

            JetTextField(
                onValueChange = {
                    description = it
                },
                title = "توضیحات فروشگاه",
                placeholder = "توضیحات فروشگاه",
                maxLength = 200,
                singleLine = false,
                maxLines = 4,
                keyboardType = KeyboardType.Text,
                height = 130
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Column(modifier = Modifier.weight(1f)) {
                    StandardDialog(
                        title = "استان",
                        dialogTitle = "انتخاب استان",
                        items = listOf("تهران", "اصفهان", "شیراز")
                    )
                }

                Spacer(modifier = Modifier.width(15.dp))

                Column(modifier = Modifier.weight(1f)) {
                    StandardDialog(
                        title = "شهر",
                        dialogTitle = "انتخاب شهر",
                        items = listOf("تهران", "اسلامشهر", "کرج")
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Column(modifier = Modifier.weight(1f)) {
                    StandardDialog(
                        title = "دسته بندی فروشگاه",
                        dialogTitle = "انتخاب دسته بندی فروشگاه",
                        items = sellerCategoryItems
                    )
                }

                Spacer(modifier = Modifier.width(15.dp))

                Column(modifier = Modifier.weight(1f)) {
                    StandardDialog(
                        title = "نوع فروشگاه",
                        dialogTitle = "انتخاب نوع فروشگاه",
                        items = resultCategoryItems
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {

                    JetTextField(
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

                Spacer(modifier = Modifier.width(15.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {

                    JetTextField(
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

            Spacer(modifier = Modifier.height(20.dp))

            JetTextField(
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

@Composable
@Preview
fun SellerDetailsScreenPreview() {
    SellerDetailsScreen()
}