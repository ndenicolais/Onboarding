package com.denicks21.onboarding.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.denicks21.onboarding.screens.HomePage
import com.denicks21.onboarding.screens.IntroPage
import com.denicks21.onboarding.screens.OnBoardingPage
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = NavScreens.IntroPage.route) {
            IntroPage(navController = navController)
        }
        composable(route = NavScreens.OnBoardingPage.route) {
            OnBoardingPage(navController = navController)
        }
        composable(route = NavScreens.HomePage.route) {
            HomePage()
        }
    }
}