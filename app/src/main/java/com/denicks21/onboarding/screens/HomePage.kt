package com.denicks21.onboarding.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.denicks21.onboarding.R
import com.denicks21.onboarding.ui.composables.BackPress
import com.denicks21.onboarding.ui.theme.GreyDark
import com.denicks21.onboarding.ui.theme.YellowDark

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePage() {
    val uriHandler = LocalUriHandler.current

    BackPress(onBackPressed = {})
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(YellowDark),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "HOMEPAGE",
                modifier = Modifier.fillMaxWidth(),
                color = GreyDark,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    modifier = Modifier.fillMaxSize(0.3f),
                    onClick = { uriHandler.openUri("https://github.com/ndenicolais") }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.github_logo),
                        contentDescription = "Open GitHub"
                    )
                }
            }
        }
    }
}