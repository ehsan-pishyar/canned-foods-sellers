package ir.androad.cannedfoods.views

import android.provider.SyncStateContract.Columns
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.components.StandardProductItem
import ir.androad.cannedfoods.components.StandardText
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun DashboardScreen(navController: NavController) {

    var banner by remember { mutableStateOf("") }
    var logoUploaded by remember { mutableStateOf(false) }
    var rating: Float by remember { mutableStateOf(4.5f) }

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

                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        StandardText(
                            text = "عنوان فروشنده عنوان فروشنده",
                            fontSize = 13,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {

                        if (logoUploaded) {
                            Card(
                                modifier = Modifier
                                    .size(110.dp)
                                    .offset(y = (-65).dp)
                                    .border(BorderStroke(3.dp, color = PrimaryColor), CircleShape),
                                shape = RoundedCornerShape(200.dp)
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.user),
                                    contentDescription = "logo",
                                    contentScale = ContentScale.Fit
                                )
                            }
                        } else {
                            Card(
                                modifier = Modifier
                                    .size(110.dp)
                                    .offset(y = (-65).dp)
                                    .border(
                                        BorderStroke(3.dp, color = LighterGrayColor),
                                        CircleShape
                                    ),
                                shape = RoundedCornerShape(200.dp)
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.user),
                                    contentDescription = "logo",
                                    contentScale = ContentScale.Fit
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {

                            Column(
                                modifier = Modifier
                                    .weight(0.8f),
                                horizontalAlignment = Alignment.Start
                            ) {
                                StandardText(
                                    text = "امتیاز :",
                                    fontSize = 12,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .weight(1.2f)
                                    .align(Alignment.CenterVertically),
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.Center
                            ) {

                                RatingBar(
                                    value = rating,
                                    config = RatingBarConfig()
                                        .style(RatingBarStyle.HighLighted)
                                        .numStars(5)
                                        .size(12.dp)
                                        .padding(1.dp)
                                        .inactiveColor(LighterGrayColor),
                                    onValueChange = {
                                        rating = it
                                    },
                                    onRatingChanged = {
                                        Log.d("TAG", "onRatingChanged: $it")
                                    }
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp)
                        ) {

                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.Start
                            ) {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Icon(
                                        modifier = Modifier.width(20.dp),
                                        painter = painterResource(id = R.drawable.timer),
                                        contentDescription = "",
                                        tint = PrimaryColor
                                    )

                                    StandardText(
                                        modifier = Modifier.padding(horizontal = 3.dp),
                                        text = "10 دقیقه",
                                        fontSize = 9,
                                        fontWeight = FontWeight.Medium,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.Center
                            ) {

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Icon(
                                        modifier = Modifier.width(20.dp),
                                        painter = painterResource(id = R.drawable.delivery),
                                        contentDescription = "",
                                        tint = PrimaryColor
                                    )

                                    StandardText(
                                        modifier = Modifier.padding(horizontal = 3.dp),
                                        text = "10000 ت",
                                        fontSize = 9,
                                        fontWeight = FontWeight.Medium,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .offset(y = (-40).dp)
                ) {

                    StandardText(
                        text = "توضیحات فروشگاه:",
                        fontWeight = FontWeight.SemiBold
                    )

                    StandardText(
                        text = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است",
                        fontSize = 12,
                        color = LightGrayColor,
                        maxLines = 4
                    )

                    StandardText(
                        modifier = Modifier.padding(PaddingValues(top = 20.dp)),
                        text = "محصولات فروشنده:",
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start
                    )

                    LazyVerticalGrid(
                        modifier = Modifier.padding(PaddingValues(top = 10.dp)),
                        columns = GridCells.Fixed(2),
                        content = {
                            items(10) { item ->
                                StandardProductItem(navController = NavController(LocalContext.current))
                            }
                        },
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewDashboardScreen() {
    DashboardScreen(navController = NavController(LocalContext.current.applicationContext))
}