package com.denicks21.onboarding.navigation

sealed class NavScreens(val route: String) {
    object IntroPage: NavScreens(route = "IntroPage")

    object OnboardingPage: NavScreens(route = "Onboarding")

    object HomePage: NavScreens(route = "HomePage")
}