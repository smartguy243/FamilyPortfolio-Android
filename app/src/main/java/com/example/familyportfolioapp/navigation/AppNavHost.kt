package com.example.familyportfolioapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.familyportfolioapp.ui.screen.AnimatedSplashScreen
import com.example.familyportfolioapp.ui.screen.DetailScreen
import com.example.familyportfolioapp.ui.screen.HomeScreen
import com.godsonpeya.myfamily.navigation.AppScreen

@Composable
fun AppNavHost(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = AppScreen.Splash.route) {

        composable(AppScreen.Splash.route) {
            AnimatedSplashScreen(navHostController = navHostController)
        }

        composable(AppScreen.MemberList.route) {
            HomeScreen(navController = navHostController)
        }
        composable(AppScreen.Detail.route) { navBackStackEntry ->
            val memberId = navBackStackEntry.arguments?.getString("memberId")
            DetailScreen(navHostController = navHostController, memberId = memberId!!)
        }

    }
}