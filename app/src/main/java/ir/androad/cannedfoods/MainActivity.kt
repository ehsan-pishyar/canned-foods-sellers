package ir.androad.cannedfoods

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import ir.androad.cannedfoods.navigations.AppNavigation
import ir.androad.cannedfoods.ui.theme.CannedFoodsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            CannedFoodsTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
