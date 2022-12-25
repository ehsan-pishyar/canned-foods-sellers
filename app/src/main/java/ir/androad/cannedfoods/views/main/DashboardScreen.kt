package ir.androad.cannedfoods.views.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.androad.cannedfoods.R
import ir.androad.cannedfoods.components.JetText
import ir.androad.cannedfoods.ui.theme.*

@Composable
fun DashboardScreen(
    toRegisterScreen: () -> Unit
) {
    var banner by remember { mutableStateOf("") }
    val logoUploaded by remember { mutableStateOf(false) }
    var rating: Float by remember { mutableStateOf(4.5f) }
    val isOpen by remember { mutableStateOf(false) }
    val tabState by remember { mutableStateOf(0) }
    val tabTitles = listOf("توضیحات فروشنده", "محصولات فروشنده")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState())
    ) {

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

            Column{
                if (logoUploaded) {
                    Card(
                        modifier = Modifier
                            .size(110.dp)
                            .offset(y = (-55).dp)
                            .border(
                                BorderStroke(3.dp, color = PrimaryColor),
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
                } else {
                    Card(
                        modifier = Modifier
                            .size(110.dp)
                            .offset(y = (-55).dp)
                            .border(
                                BorderStroke(3.dp, color = PrimaryColor),
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

            JetText(
                modifier = Modifier.offset(y = (-40).dp),
                text = "عنوان فروشنده",
                fontSize = 18,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            JetText(
                modifier = Modifier.offset(y = (-40).dp),
                text = "(تهران - میدان ولی عصر)",
                fontSize = 12,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = LightGrayColor
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-20).dp)
                    .padding(horizontal = 10.dp)
            ) {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .padding(5.dp)
                        .border(
                            width = 2.dp,
                            color = PrimaryColor,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    if (!isOpen) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Icon(
                                modifier = Modifier
                                    .size(15.dp)
                                    .offset(y = 10.dp),
                                painter = painterResource(id = R.drawable.circle),
                                contentDescription = null,
                                tint = RedColor
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                            JetText(
                                text = "بسته است",
                                fontSize = 12,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    } else {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Icon(
                                modifier = Modifier
                                    .size(20.dp)
                                    .offset(y = 10.dp),
                                painter = painterResource(id = R.drawable.circle),
                                contentDescription = null,
                                tint = GreenColor
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            JetText(
                                text = "باز است",
                                fontSize = 12,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .padding(5.dp)
                        .border(
                            width = 2.dp,
                            color = PrimaryColor,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Icon(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(id = R.drawable.delivery),
                            contentDescription = null,
                            tint = PrimaryColor
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        JetText(
                            text = "10000 ت",
                            fontSize = 12,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .padding(5.dp)
                        .border(
                            width = 2.dp,
                            color = PrimaryColor,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
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
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .padding(5.dp)
                        .border(
                            width = 2.dp,
                            color = PrimaryColor,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Icon(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            tint = YellowColor
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        JetText(
                            text = "4.5 / 5.0",
                            fontSize = 12,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
            ) {

                JetText(
                    text = "توضیحات فروشگاه:",
                    fontWeight = FontWeight.SemiBold
                )

                JetText(
                    text = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است",
                    fontSize = 12,
                    color = LightGrayColor,
                    maxLines = 4
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewDashboardScreen() {
    DashboardScreen {

    }
}