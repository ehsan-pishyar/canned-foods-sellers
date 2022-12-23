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

@Composable
fun AppNavigation(
    navController: NavHostController
    ) {

    NavHost(
        route = Graph.ROOT,
        navController = navController,
        startDestination = Graph.START //Screen.Dashboard.route
    ) {
        addStartTopLevel(navController = navController)
        addAuthTopLevel(navController = navController)
        addMainTopLevel(navController = navController)
    }

}

fun NavGraphBuilder.addStartTopLevel(
    navController: NavHostController
) {
    navigation(
        route = Graph.START,
        startDestination = StartScreens.OnBoarding.route
    ) {
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
        addLogin(
            navController = navController,

            )
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

private fun NavGraphBuilder.addDashboard(
    navController: NavHostController
) {
    composable(route = JetMainScreens.Dashboard.createRoute(MainScreens.Dashboard)) {
        DashboardScreen(
            toRegisterScreen = {
                navController.navigate(route = JetAuthScreens.Register.createRoute(AuthScreens.Register))
            }
        )
    }
}

private fun NavGraphBuilder.addFoods(
    navController: NavHostController
) {
    composable(route = JetMainScreens.Foods.createRoute(MainScreens.Foods)) {
        FoodsScreen()
    }
}

private fun NavGraphBuilder.addOrders(
    navController: NavHostController
) {
    composable(route = JetMainScreens.Orders.createRoute(MainScreens.Orders)) {
        OrdersScreen()
    }
}

private fun NavGraphBuilder.addIncomes(
    navController: NavHostController
) {
    composable(route = JetMainScreens.Income.createRoute(MainScreens.Income)) {
        IncomesScreen()
    }
}

private fun NavGraphBuilder.addLogin(
    navController: NavHostController
    ) {
    composable(route = JetAuthScreens.Login.createRoute(AuthScreens.Login)) {
        LoginScreen(
            toRegisterScreen = {
                navController.navigate(
                    JetAuthScreens.Register.createRoute(
                        AuthScreens.Register
                    )
                )
            },
            toForgotPasswordScreen = {
                navController.navigate(
                    JetAuthScreens.ForgotPassword.createRoute(
                        AuthScreens.ForgotPassword
                    )
                )
            },
            toDashboardScreen = {
                navController.navigate(
                    JetMainScreens.Dashboard.createRoute(
                        MainScreens.Dashboard
                    )
                )
            }
        )
    }
}

private fun NavGraphBuilder.addRegister(
    navController: NavHostController
) {
    composable(route = JetAuthScreens.Register.createRoute(AuthScreens.Register)) {
        RegisterScreen(
            toLoginScreen = { navController.navigate(JetAuthScreens.Login.createRoute(AuthScreens.Login)) },
            toDashboardScreen = { navController.navigate(JetMainScreens.Dashboard.createRoute(MainScreens.Dashboard)) }
        )
    }
}

private fun NavGraphBuilder.addForgotPassword(
    navController: NavHostController
) {
    composable(route = JetAuthScreens.ForgotPassword.createRoute(AuthScreens.ForgotPassword)) {
        ForgotPasswordScreen(
            toLoginScreen = { navController.navigate(JetAuthScreens.Login.createRoute(AuthScreens.Login)) },
            toRecoveryPasswordScreen = {navController.navigate(JetAuthScreens.PasswordRecovery.createRoute(AuthScreens.PasswordRecovery))}
        )
    }
}

private fun NavGraphBuilder.addPasswordRecovery(
    navController: NavHostController
) {
    composable(route = JetAuthScreens.PasswordRecovery.createRoute(AuthScreens.PasswordRecovery)) {
        PasswordRecoveryScreen(
            toLoginScreen = { navController.navigate(JetAuthScreens.Login.createRoute(AuthScreens.Login)) },
            toDashboardScreen = { navController.navigate(JetMainScreens.Dashboard.createRoute(MainScreens.Dashboard)) }
        )
    }
}

private fun NavGraphBuilder.addOnBoarding(
    navController: NavHostController
) {
    composable(route = StartScreens.OnBoarding.route) {
        OnBoardingScreen(
            toLoginScreen = { navController.navigate(JetAuthScreens.Login.createRoute(AuthScreens.Login)) }
        )
    }
}

object Graph {
    const val ROOT = "root"
    const val START = "start"
    const val AUTH = "auth"
    const val MAIN = "main"
}