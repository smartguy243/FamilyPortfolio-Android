package com.example.familyportfolioapp.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.familyportfolioapp.navigation.AppScreen
import com.example.familyportfolioapp.ui.components.Splash
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navHostController: NavHostController) {

    var startAnimation by remember { mutableStateOf(false) }
    val logoAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        )
    )
    val textAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 6000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navHostController.popBackStack()
        navHostController.navigate(AppScreen.MemberRegistration.route)
    }

    Splash(logoAnimation = logoAnimation.value, textAnimation = textAnimation.value)
}