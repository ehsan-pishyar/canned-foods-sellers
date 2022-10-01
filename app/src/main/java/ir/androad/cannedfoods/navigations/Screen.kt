package ir.androad.cannedfoods.navigations

sealed class Screen(val route: String) {

    object WelcomeScreen: Screen(route = "welcome_screen")
    object SplashScreen: Screen(route = "splash_screen")
    object LoginScreen: Screen(route = "login_screen")
    object RegisterScreen: Screen(route = "register_screen")
    object PasswordRecoveryScreen: Screen(route = "password_recovery_screen")
    object DashboardScreen: Screen(route = "dashboard_screen")
    object ResultsScreen: Screen(route = "results_screen")
    object ResultDetailsScreen: Screen(route = "result_details_screen")
    object SellerDetailsScreen: Screen(route = "seller_details_screen")
}
