package ir.androad.cannedfoods.navigations

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.androad.cannedfoods.views.*

@Composable
fun Navigation(navController: NavHostController) {
    
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route,
        modifier = Modifier.fillMaxSize()
        ) {

        composable(
            route = Screen.WelcomeScreen.route
        ) {
            WelcomeScreen(navController)
        }
        composable(
            route = Screen.SplashScreen.route
        ) {
            SplashScreen(navController)
        }
        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(navController)
        }
        composable(
            route = Screen.RegisterScreen.route
        ) {
            RegisterScreen(navController)
        }
        composable(
            route = Screen.PasswordRecoveryScreen.route
        ) {
            PasswordRecoveryScreen(navController)
        }
        composable(
            route = Screen.DashboardScreen.route
        ) {
            DashboardScreen(navController)
        }
        composable(
            route = Screen.ResultsScreen.route
        ) {
            ResultsScreen(navController)
        }
        composable(
            route = Screen.ResultDetailsScreen.route
        ) {
            ResultDetailsScreen(navController)
        }
        composable(
            route = Screen.SellerDetailsScreen.route
        ) {
            SellerDetailsScreen(navController)
        }
    }
}