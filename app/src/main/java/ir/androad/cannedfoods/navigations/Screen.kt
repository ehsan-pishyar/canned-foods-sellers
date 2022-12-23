package ir.androad.cannedfoods.navigations

sealed class StartScreens(val route: String) {
    object OnBoarding: StartScreens(route = "onboarding")
}

sealed class AuthScreens(val route: String) {
    object Login: AuthScreens(route = "login")
    object Register: AuthScreens(route = "register")
    object ForgotPassword: AuthScreens(route = "forgot_password")
    object PasswordRecovery: AuthScreens(route = "password_recovery")
}

sealed class MainScreens (val route: String) {
    object Dashboard: MainScreens(route = "dashboard")
    object Foods: MainScreens(route = "foods")
    object Orders: MainScreens(route = "orders")
    object Income: MainScreens(route = "income")
}

sealed class JetStartScreens(private val route: String) {
    fun createRoute(root: StartScreens) = "${root.route}/$route"

    object OnBoarding: JetStartScreens(route = "onboarding")
}

sealed class JetAuthScreens(private val route: String) {
    fun createRoute(root: AuthScreens) = "${root.route}/$route"

    object Login: JetAuthScreens(route = "login")
    object Register: JetAuthScreens(route = "register")
    object ForgotPassword: JetAuthScreens(route = "forgot_password")
    object PasswordRecovery: JetAuthScreens(route = "recovery_password")
}

sealed class JetMainScreens(private val route: String) {
    fun createRoute(root: MainScreens) = "${root.route}/$route"

    object Dashboard: JetMainScreens(route = "dashboard")
    object Foods: JetMainScreens(route = "foods")
    object Orders: JetMainScreens(route = "orders")
    object Income: JetMainScreens(route = "income")

    object ProfileDetails: JetMainScreens("profile/{profileId}") {
        fun createRoute(root: MainScreens, profileId: Long) =
            "${root.route}/profile/$profileId"
    }

    object FoodDetails: JetMainScreens("foods/{foodId}") {
        fun createRoute(root: MainScreens, foodId: Long) =
            "${root.route}/foods/$foodId"
    }

    object OrderDetails: JetMainScreens("orders/{orderId}") {
        fun createRoute(root: MainScreens, orderId: Long) {
            "${root.route}/orders/$orderId"
        }
    }

    object IncomeDetails: JetMainScreens("incomes/{incomeId}") {
        fun createRoute(root: MainScreens, incomeId: Long) {
            "${root.route}/incomes/$incomeId"
        }
    }
}