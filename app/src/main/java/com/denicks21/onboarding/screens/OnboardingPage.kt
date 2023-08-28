package com.denicks21.onboarding.screens

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.denicks21.onboarding.navigation.NavScreens
import com.denicks21.onboarding.navigation.OnboardingScreen
import com.denicks21.onboarding.ui.components.FinishButton
import com.denicks21.onboarding.ui.components.TopComponent
import com.denicks21.onboarding.ui.theme.DarkGrey
import com.denicks21.onboarding.ui.theme.LightYellow
import com.denicks21.onboarding.viewmodels.HomeViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingPage(
    navController: NavHostController,
    welcomeViewModel: HomeViewModel = hiltViewModel(),
) {
    val pages = listOf(
        OnboardingScreen.FirstScreen,
        OnboardingScreen.SecondScreen,
        OnboardingScreen.ThirdScreen,
        OnboardingScreen.FourthScreen
    )
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopComponent(
                onBackClick = {
                    if (pagerState.currentPage + 1 > 1) scope.launch {
                        pagerState.scrollToPage(pagerState.currentPage - 1)
                    }
                },
                onSkipClick = { navController.navigate(NavScreens.HomePage.route) }
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = if (isSystemInDarkTheme()) LightYellow else DarkGrey,
                    inactiveColor = if (isSystemInDarkTheme()) DarkGrey else LightYellow,
                    indicatorWidth = 10.dp,
                    indicatorHeight = 10.dp
                )
                Spacer(modifier = Modifier.height(10.dp))
                FinishButton(
                    modifier = Modifier
                        .height(60.dp)
                        .width(350.dp)
                        .padding(bottom = 10.dp),
                    pagerState = pagerState
                ) {
                    welcomeViewModel.saveOnBoardingState(completed = true)
                    navController.popBackStack()
                    navController.navigate(NavScreens.HomePage.route)
                }
            }
        },
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            HorizontalPager(
                count = 4,
                state = pagerState,
                verticalAlignment = Alignment.CenterVertically
            ) { position ->
                PagerScreen(onBoardingScreen = pages[position])
            }
        }
    }
}

@Composable
fun PagerScreen(onBoardingScreen: OnboardingScreen) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = onBoardingScreen.title,
            modifier = Modifier.fillMaxWidth(),
            color = DarkGrey,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Image(
            modifier = Modifier
                .width(400.dp)
                .height(400.dp),
            painter = painterResource(id = onBoardingScreen.image),
            contentDescription = "Pager image"
        )
        Text(
            text = onBoardingScreen.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            color = DarkGrey,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}