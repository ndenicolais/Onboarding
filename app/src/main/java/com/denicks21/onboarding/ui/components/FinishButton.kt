package com.denicks21.onboarding.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Verified
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.denicks21.onboarding.ui.theme.DarkGrey
import com.denicks21.onboarding.ui.theme.LightYellow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier.padding(horizontal = 80.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 3
        ) {
            FloatingActionButton(
                onClick = onClick,
                backgroundColor = DarkGrey
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Finish",
                        modifier = Modifier.padding(end = 10.dp),
                        color = LightYellow,
                        fontSize = 18.sp
                    )
                    Icon(
                        imageVector = Icons.Filled.Verified,
                        contentDescription = "Finish",
                        tint = LightYellow
                    )
                }
            }
        }
    }
}