package ir.androad.cannedfoods.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.components.JetText
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun OrdersScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {

        Column(modifier = Modifier.padding(15.dp)) {
            Column(
                modifier = Modifier
                    .wrapContentSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                JetText(
                    text = "سفارشات مشتری",
                    textAlign = TextAlign.Center,
                    fontSize = 25,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                JetText(
                    text = "آخرین سفارشات مشتری خودتونو اینجا ببینین. همچنین سفارشات اخیرتون رو هم همینطور.",
                    textAlign = TextAlign.Center,
                    fontSize = 16,
                    fontWeight = FontWeight.Normal,
                    color = GrayColor,
                    maxLines = 2
                )
            }

            Column(
                modifier = Modifier
                    .wrapContentSize()
            ) {

                Spacer(modifier = Modifier.height(30.dp))

                JetText(
                    text = "سفارشات اخیر",
                    textAlign = TextAlign.Start,
                    fontSize = 17,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Card(
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(20.dp)
                            .background(Color.White)
                    ) {
                        JetText(
                            text = "احسان پیش یار",
                            textAlign = TextAlign.Center,
                            fontSize = 16,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth()
                        )
                        JetText(
                            text = "خیابان قزوین، دوراهی قپان، پلاک 29، واحد 7",
                            textAlign = TextAlign.Center,
                            fontSize = 14,
                            fontWeight = FontWeight.Normal,
                            color = GrayColor,
                            maxLines = 2,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        JetText(
                            text = "سفارشات",
                            textAlign = TextAlign.Center,
                            fontSize = 16,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {
                            Column(
                                modifier = Modifier.width(100.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    painter = painterResource(id = R.drawable.timer),
                                    contentDescription = null,
                                    tint = PrimaryColor
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                JetText(
                                    text = "همبرگر با پنیر گودا",
                                    fontSize = 12,
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 2
                                )
                            }
                            Column(
                                modifier = Modifier.width(100.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    painter = painterResource(id = R.drawable.timer),
                                    contentDescription = null,
                                    tint = PrimaryColor
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                JetText(
                                    text = "9 دقیقه",
                                    fontSize = 12,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            JetText(
                                text = "قیمت:",
                                fontSize = 16,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                            )
                            JetText(
                                text = "12000 تومان",
                                fontSize = 16,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            JetText(
                                text = "تاریخ و زمان:",
                                fontSize = 16,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                            )
                            JetText(
                                text = "امروز، ساعت: 15:30",
                                fontSize = 16,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                            )
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .weight(1f),
                                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor),
                                shape = RoundedCornerShape(12.dp),
                                elevation = ButtonDefaults.elevation(
                                    defaultElevation = 0.dp,
                                    pressedElevation = 0.dp,
                                    disabledElevation = 0.dp
                                )
                            ) {
                                Text(
                                    text = "تایید",
                                    fontFamily = Yekanbakh,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontStyle = FontStyle.Normal,
                                    color = Color.White
                                )
                            }
                            
                            Spacer(modifier = Modifier.width(10.dp))

                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .weight(1f)
                                    .border(
                                        width = 2.dp,
                                        color = PrimaryColor,
                                        shape = RoundedCornerShape(12.dp)
                                    ),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                                shape = RoundedCornerShape(12.dp),
                                elevation = ButtonDefaults.elevation(
                                    defaultElevation = 0.dp,
                                    pressedElevation = 0.dp,
                                    disabledElevation = 0.dp
                                )
                            ) {
                                Text(
                                    text = "رد سفارش",
                                    fontFamily = Yekanbakh,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontStyle = FontStyle.Normal,
                                    color = PrimaryColor
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                JetText(
                    text = "تاریخچه سفارشات",
                    textAlign = TextAlign.Start,
                    fontSize = 17,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Card(
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(20.dp)
                            .background(Color.White)
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            JetText(
                                text = "محمد محمدی",
                                fontSize = 16,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                            )
                            JetText(
                                text = "انجام شده",
                                fontSize = 14,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.End,
                                color = GreenColor,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Divider()

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {
                            JetText(
                                text = "محید صالحی",
                                fontSize = 16,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                            )
                            JetText(
                                text = "انجام شده",
                                fontSize = 14,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.End,
                                color = GreenColor,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewOrdersScreen() {
    OrdersScreen()
}