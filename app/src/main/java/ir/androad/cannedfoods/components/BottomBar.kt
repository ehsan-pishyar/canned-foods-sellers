package ir.androad.cannedfoods.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.androad.cannedfoods.navigations.BottomNavItem

@Composable
fun BottomBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val currentDestination = item.route == navBackStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = currentDestination,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(badge = {
                                Text(text = "${item.badgeCount}")
                            }) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title
                                )
                                Text(
                                    text = item.title,
                                    textAlign = TextAlign.Center,
                                    fontSize = 14.sp
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title
                            )
                            Text(
                                text = item.title,
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            )
        }
    }

//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .background(Color.White)
//    ) {
//        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
//            Column(modifier = modifier.fillMaxWidth()) {
//
//            }
//        }
//    }
}