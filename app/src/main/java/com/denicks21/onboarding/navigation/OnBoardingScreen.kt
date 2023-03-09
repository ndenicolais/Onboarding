package com.denicks21.onboarding.navigation

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import com.denicks21.onboarding.R

sealed class OnBoardingScreen(
    @SuppressLint("SupportAnnotationUsage")
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object FirstScreen : OnBoardingScreen(
        image = R.drawable.image1,
        title = "Home",
        description = "The starting point for a trip"
    )

    object SecondScreen : OnBoardingScreen(
        image = R.drawable.image2,
        title = "Bag",
        description = "The moment of luggage preparation"
    )

    object ThirdScreen : OnBoardingScreen(
        image = R.drawable.image3,
        title = "Trip",
        description = "The departure to the destination"
    )
}
