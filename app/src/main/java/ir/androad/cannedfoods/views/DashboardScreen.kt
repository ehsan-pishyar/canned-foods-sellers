package ir.androad.cannedfoods.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun DashboardScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                var banner by remember { mutableStateOf("") }
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.banner),
                    contentDescription = "banner",
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        modifier = Modifier.width(110.dp),
                        text = "عنوان فروشنده عنوان فروشنده عنوان فروشنده",
                        fontFamily = Yekanbakh,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        color = BlackColor,
                        textAlign = TextAlign.Start,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Card(
                        modifier = Modifier
                            .size(110.dp)
                            .offset(y = (-65).dp)
                            .border(BorderStroke(4.dp, color = LighterGrayColor), CircleShape),
                        shape = RoundedCornerShape(200.dp)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "user",
                            contentScale = ContentScale.Fit
                        )
                    }

                    Text(
                        modifier = Modifier
                            .width(110.dp),
                        text = "ثبت نام",
                        fontFamily = Yekanbakh,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                        color = BlackColor,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .offset(y = (-40).dp)
                ) {

                    Text(
                        text = "توضیحات فروشگاه:",
                        fontFamily = Yekanbakh,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                        color = BlackColor
                    )

                    Text(
                        text = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است",
                        fontFamily = Yekanbakh,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = LightGrayColor,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}