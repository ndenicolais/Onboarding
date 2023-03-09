package com.denicks21.onboarding.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.denicks21.onboarding.navigation.NavScreens
import com.denicks21.onboarding.ui.composables.FinishButton
import com.denicks21.onboarding.ui.composables.TopComponent
import com.denicks21.onboarding.ui.theme.GreyDark
import com.denicks21.onboarding.ui.theme.GreyLight
import com.denicks21.onboarding.navigation.OnBoardingScreen
import com.denicks21.onboarding.viewmodels.HomeViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnBoardingPage(
    navController: NavHostController,
    welcomeViewModel: HomeViewModel = hiltViewModel(),
) {
    val pages = listOf(
        OnBoardingScreen.FirstScreen,
        OnBoardingScreen.SecondScreen,
        OnBoardingScreen.ThirdScreen
    )
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopComponent(
            onBackClick = {
                if (pagerState.currentPage + 1 > 1) scope.launch {
                    pagerState.scrollToPage(pagerState.currentPage - 1)
                }
            },
            onSkipClick = {
                navController.navigate(NavScreens.HomePage.route)
            }
        )
        HorizontalPager(
            modifier = Modifier.weight(7f),
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.CenterVertically
        ) { position ->
            PagerScreen(
                onBoardingScreen = pages[position]
            )
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1.6f),
            pagerState = pagerState,
            activeColor = GreyDark,
            inactiveColor = GreyLight,
            indicatorWidth = 10.dp,
            indicatorHeight = 10.dp
        )
        FinishButton(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 10.dp),
            pagerState = pagerState
        ) {
            welcomeViewModel.saveOnBoardingState(completed = true)
            navController.popBackStack()
            navController.navigate(NavScreens.HomePage.route)
        }
    }
}

@Composable
fun PagerScreen(onBoardingScreen: OnBoardingScreen) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            text = onBoardingScreen.title,
            color = GreyDark,
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Image(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp),
            painter = painterResource(id = onBoardingScreen.image),
            contentDescription = "Pager image"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 20.dp),
            text = onBoardingScreen.description,
            color = GreyDark,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview(showBackground = true)
fun FirstOnBoardingScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PagerScreen(
            onBoardingScreen = OnBoardingScreen.FirstScreen
        )
    }
}

@Composable
@Preview(showBackground = true)
fun SecondOnBoardingScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PagerScreen(
            onBoardingScreen = OnBoardingScreen.SecondScreen
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ThirdOnBoardingScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PagerScreen(
            onBoardingScreen = OnBoardingScreen.ThirdScreen
        )
    }
}

