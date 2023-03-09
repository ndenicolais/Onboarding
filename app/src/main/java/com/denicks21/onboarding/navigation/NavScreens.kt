package com.denicks21.onboarding.navigation

sealed class NavScreens(val route: String) {
    object IntroPage: NavScreens(route = "IntroPage")
    object OnBoardingPage: NavScreens(route = "OnBoarding")
    object HomePage: NavScreens(route = "HomePage")
}