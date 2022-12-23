package ir.androad.cannedfoods.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import ir.androad.cannedfoods.navigations.BottomNavItem
import ir.androad.cannedfoods.navigations.MainScreens

object BottomNavData {
    val items: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = MainScreens.Dashboard.route,
            title = "پیشخوان",
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            route = MainScreens.Foods.route,
            title = "آیتم ها",
            icon = Icons.Default.Add
        ),
        BottomNavItem(
            route = MainScreens.Dashboard.route,
            title = "سفارشات",
            icon = Icons.Default.ThumbUp
        ),
        BottomNavItem(
            route = MainScreens.Dashboard.route,
            title = "درآمدها",
            icon = Icons.Default.Call
        )
    )
}