package com.denicks21.onboarding.navigation

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import com.denicks21.onboarding.R

sealed class OnboardingScreen(
    @SuppressLint("SupportAnnotationUsage")
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object FirstScreen : OnboardingScreen(
        image = R.drawable.onboarding_1,
        title = "Action",
        description = "Action to make the process definitive and/ or improve"
    )

    object SecondScreen : OnboardingScreen(
        image = R.drawable.onboarding_2,
        title = "Plan",
        description = "Establish the objectives and processes necessary to deliver results"
    )

    object ThirdScreen : OnboardingScreen(
        image = R.drawable.onboarding_3,
        title = "Do",
        description = "Implement the plan, run the process, create the product"
    )

    object FourthScreen : OnboardingScreen(
        image = R.drawable.onboarding_4,
        title = "Check",
        description = "Test and control, study and collection of results and feedback"
    )
}