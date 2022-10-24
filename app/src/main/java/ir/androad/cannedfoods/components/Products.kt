package ir.androad.cannedfoods.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.androad.cannedfoods.ui.theme.BackgroundColor
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.ui.theme.LightGrayColor
import ir.androad.cannedfoods.ui.theme.LighterGrayColor
import ir.androad.cannedfoods.ui.theme.PrimaryColor

@Composable
fun StandardProductItem(
    navController: NavController,
    title: String = "",
    price: Int = 0,
    rating: Double = 0.0,
    sellerTitle: String = ""
) {

    Box {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {

            Column {

                Card(
                    modifier = Modifier
                        .width(200.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(width = 1.dp, color = PrimaryColor)
                ) {

                    Column(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    modifier = Modifier.width(25.dp),
                                    painter = painterResource(id = R.drawable.share),
                                    contentDescription = null,
                                    tint = PrimaryColor
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    modifier = Modifier.width(25.dp),
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = null,
                                    tint = PrimaryColor
                                )
                            }
                        }

                        Image(
                            modifier = Modifier
                                .size(100.dp),
                            painter = painterResource(id = R.drawable.burger2),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )

                        StandardText(
                            modifier = Modifier.padding(PaddingValues(top = 10.dp)),
                            text = "پیتزا پپرونی با قارچ",
                            fontSize = 15,
                            fontWeight = FontWeight.Bold
                        )

                        StandardText(
                            modifier = Modifier.padding(PaddingValues(top = 5.dp)),
                            text = "(فست فود امیر)",
                            fontSize = 11,
                            fontWeight = FontWeight.Normal,
                            color = LightGrayColor
                        )

                        Row(modifier = Modifier.padding(PaddingValues(top = 10.dp))) {
                            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
                                StandardText(
                                    text = "120000 ت",
                                    color = PrimaryColor,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 15
                                )
                            }
                            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                                Row {
                                    StandardText(
                                        text = "4.5",
                                        fontSize = 13
                                    )

                                    Spacer(modifier = Modifier.width(5.dp))

                                    Icon(
                                        modifier = Modifier.size(15.dp).align(Alignment.CenterVertically),
                                        painter = painterResource(id = R.drawable.star),
                                        contentDescription = null,
                                        tint = Color.Yellow
                                    )
                                }
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
fun PreviewStandardProductItem() {
    StandardProductItem(navController = NavController(LocalContext.current.applicationContext))
}