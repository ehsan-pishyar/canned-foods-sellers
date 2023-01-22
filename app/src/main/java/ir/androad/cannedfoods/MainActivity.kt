package ir.androad.cannedfoods

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.androad.cannedfoods.navigations.AppNavigation
import ir.androad.cannedfoods.ui.theme.CannedFoodsTheme
import ir.androad.cannedfoods.viewmodels.SplashScreenViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
//        installSplashScreen()
        super.onCreate(savedInstanceState)
//
//        installSplashScreen().setKeepOnScreenCondition {
//            !splashViewModel.isOnBoardingCompleted.value
//        }

        setContent {
            CannedFoodsTheme {
                val screen by splashViewModel.startDestination
                val navController = rememberNavController()
                Surface {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        AppNavigation(navController = navController, startDestination = screen)
                    }
                }
            }
        }
    }
}
