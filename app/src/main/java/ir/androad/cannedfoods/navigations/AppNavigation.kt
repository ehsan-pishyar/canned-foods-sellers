package ir.androad.cannedfoods.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ir.androad.cannedfoods.views.auth.ForgotPasswordScreen
import ir.androad.cannedfoods.views.auth.LoginScreen
import ir.androad.cannedfoods.views.auth.PasswordRecoveryScreen
import ir.androad.cannedfoods.views.auth.RegisterScreen
import ir.androad.cannedfoods.views.main.DashboardScreen
import ir.androad.cannedfoods.views.main.FoodsScreen
import ir.androad.cannedfoods.views.main.IncomesScreen
import ir.androad.cannedfoods.views.main.OrdersScreen
import ir.androad.cannedfoods.views.start.OnBoardingScreen
import ir.androad.cannedfoods.views.start.SplashScreen

@Composable
fun AppNavigation(
    navController: NavHostController
    //startDestination: String
) {

    NavHost(
        route = Graph.ROOT,
        navController = navController,
        startDestination = Graph.START //Screen.Dashboard.route //startDestination
    ) {
        addStartTopLevel(navController = navController)
        addAuthTopLevel(navController = navController)
        addMainTopLevel(navController = navController)
    }

}

fun NavGraphBuilder.addStartTopLevel(
    navController: NavHostController,
) {
    navigation(
        route = Graph.START,
        startDestination = StartScreens.Splash.route
    ) {
        addSplash(navController = navController)
        addOnBoarding(navController = navController)
    }
}

fun NavGraphBuilder.addAuthTopLevel(
    navController: NavHostController
) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreens.Login.route
    ) {
        addLogin(navController = navController)
        addRegister(navController = navController)
        addForgotPassword(navController = navController)
        addPasswordRecovery(navController = navController)
    }
}

fun NavGraphBuilder.addMainTopLevel(
    navController: NavHostController
) {
    navigation(
        route = Graph.MAIN,
        startDestination = MainScreens.Dashboard.route
    ) {
        addDashboard(navController)
        addFoods(navController)
        addOrders(navController)
        addIncomes(navController)
    }
}

private fun NavGraphBuilder.addSplash(
    navController: NavHostController
) {
    composable(route = StartScreens.Splash.route) {
        SplashScreen(
            toOnBoardingScreen = {
                navController.popBackStack()
                navController.navigate(StartScreens.OnBoarding.route)
                                 },
            toLoginScreen = {
                navController.popBackStack()
                navController.navigate(AuthScreens.Login.route)
            },
            toDashboardScreen = {
                navController.popBackStack()
                navController.navigate(MainScreens.Dashboard.route)
            }
        )
    }
}

private fun NavGraphBuilder.addOnBoarding(
    navController: NavHostController
) {
    composable(route = StartScreens.OnBoarding.route) {
        OnBoardingScreen(
            toLoginScreen = {
                navController.popBackStack()
                navController.navigate(AuthScreens.Login.route)
            }
        )
    }
}

private fun NavGraphBuilder.addLogin(
    navController: NavHostController
) {
    composable(route = AuthScreens.Login.route) {
        LoginScreen(
            toRegisterScreen = {
                navController.navigate(AuthScreens.Register.route)
            },
            toForgotPasswordScreen = {
                navController.navigate(AuthScreens.ForgotPassword.route)
            },
            toDashboardScreen = {
                navController.navigate(MainScreens.Dashboard.route)
            }
        )
    }
}

private fun NavGraphBuilder.addRegister(
    navController: NavHostController
) {
    composable(route = AuthScreens.Register.route) {
        RegisterScreen(
            toLoginScreen = { navController.navigate(AuthScreens.Login.route) },
            toDashboardScreen = { navController.navigate(MainScreens.Dashboard.route) }
        )
    }
}

private fun NavGraphBuilder.addForgotPassword(
    navController: NavHostController
) {
    composable(route = AuthScreens.ForgotPassword.route) {
        ForgotPasswordScreen(
            toLoginScreen = { navController.navigate(AuthScreens.Login.route) },
            toRecoveryPasswordScreen = {navController.navigate(AuthScreens.PasswordRecovery.route)}
        )
    }
}

private fun NavGraphBuilder.addPasswordRecovery(
    navController: NavHostController
) {
    composable(route = AuthScreens.PasswordRecovery.route) {
        PasswordRecoveryScreen(
            toLoginScreen = { navController.navigate(AuthScreens.Login.route) },
            toDashboardScreen = { navController.navigate(MainScreens.Dashboard.route) }
        )
    }
}

private fun NavGraphBuilder.addDashboard(
    navController: NavHostController
) {
    composable(route = MainScreens.Dashboard.route) {
        DashboardScreen(
            toRegisterScreen = {
                navController.navigate(AuthScreens.Register.route)
            }
        )
    }
}

private fun NavGraphBuilder.addFoods(
    navController: NavHostController
) {
    composable(route = MainScreens.Foods.route) {
        FoodsScreen()
    }
}

private fun NavGraphBuilder.addOrders(
    navController: NavHostController
) {
    composable(route = MainScreens.Orders.route) {
        OrdersScreen()
    }
}

private fun NavGraphBuilder.addIncomes(
    navController: NavHostController
) {
    composable(route = MainScreens.Income.route) {
        IncomesScreen()
    }
}

object Graph {
    const val ROOT = "root"
    const val START = "start"
    const val AUTH = "auth"
    const val MAIN = "main"
}