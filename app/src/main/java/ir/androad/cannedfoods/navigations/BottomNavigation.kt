package ir.androad.cannedfoods.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

data class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)

@Composable
fun BottomBarNavigation(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = MainScreens.Dashboard.route) {
        addMainTopLevel(navHostController)
    }
}