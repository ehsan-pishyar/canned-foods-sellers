package ir.androad.cannedfoods.navigations
//
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.navigation
//import ir.androad.cannedfoods.viewmodels.DashboardViewModel
//import ir.androad.cannedfoods.views.*
//import ir.androad.cannedfoods.views.start.OnBoardingScreen
//
//@Composable
//fun NavGraph(navController: NavHostController) {
//
//    NavHost(
//        navController = navController,
//        startDestination = Graph.ROOT
//        ) {
//        startNavigation(navController = navController)
//        authNavigation(navController = navController)
//        mainNavigation(navController = navController)
//    }
//}
//
//fun NavGraphBuilder.startNavigation(navController: NavHostController) {
//    composable(
//        route = StartScreens.OnBoarding.route
//    ) {
//        OnBoardingScreen(
//            toDashboardScreen = { navController.navigate(MainScreens.Dashboard.route) }
//        )
//    }
//}
//
//fun NavGraphBuilder.authNavigation(navController: NavHostController) {
//    navigation(
//        route = Graph.AUTH,
//        startDestination = AuthScreens.Login.route
//    ) {
//        composable(route = AuthScreens.Login.route) {
//            LoginScreen(navController = navController)
//        }
//        composable(route = AuthScreens.Register.route) {
//            RegisterScreen(navController = navController)
//        }
//        composable(route = AuthScreens.ForgotPassword.route) {
//            ForgotPasswordScreen(navController = navController)
//        }
//    }
//}
//
//fun NavGraphBuilder.mainNavigation(navController: NavHostController) {
//    navigation(
//        route = Graph.MAIN,
//        startDestination = MainScreens.Dashboard.route
//    ) {
//        composable(route = MainScreens.Dashboard.route) {
//            DashboardScreen(
//                openEditDashboardScreen = { navController.navigate(AuthScreens.Register.route) }
//            )
//        }
//        composable(route = MainScreens.Foods.route) {
//            FoodsScreen(navController = navController)
//        }
//        composable(route = MainScreens.Orders.route) {
//            OrdersScreen(navController = navController)
//        }
//        composable(route = MainScreens.Income.route) {
//            IncomesScreen(navController = navController)
//        }
//    }
//}
//
