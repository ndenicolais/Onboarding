package com.denicks21.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.denicks21.onboarding.navigation.NavGraph
import com.denicks21.onboarding.ui.theme.GreyDark
import com.denicks21.onboarding.ui.theme.OnBoardingTheme
import com.denicks21.onboarding.viewmodels.IntroViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var introViewModel: IntroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            !introViewModel.isLoading.value
        }

        setContent {
            OnBoardingTheme() {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setNavigationBarColor(
                        GreyDark,
                        darkIcons = false
                    )
                }
                val startScreen = introViewModel.startDestination
                val navController = rememberNavController()
                NavGraph(navController = navController, startDestination = startScreen.value)
            }
        }
    }
}