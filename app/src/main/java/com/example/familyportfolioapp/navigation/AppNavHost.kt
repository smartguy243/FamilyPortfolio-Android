package com.example.familyportfolioapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.familyportfolioapp.ui.screen.AnimatedSplashScreen
import com.example.familyportfolioapp.ui.screen.MemberDetailsScreen
import com.example.familyportfolioapp.ui.screen.MemberListScreen
import com.example.familyportfolioapp.ui.screen.MemberRegistrationScreen
import java.util.UUID

@Composable
fun AppNavHost(navHostController: NavHostController) {

    NavHost(startDestination= AppScreen.AnimatedSplash.route, navController = navHostController){

        composable(route = AppScreen.AnimatedSplash.route){
            AnimatedSplashScreen(navHostController)
        }

        composable(route = AppScreen.MemberRegistration.route){
            MemberRegistrationScreen(navHostController)
        }

        composable(route = AppScreen.MemberList.route){
            MemberListScreen(navHostController)
        }

        composable(
            route = AppScreen.MemberDetails.route + "/{memberId}",
            arguments = listOf(
                navArgument(
                    name = "memberId"){
                    type = NavType.StringType }
            ))
        { navBackStackEntry ->

            val memberId = UUID.fromString(navBackStackEntry.arguments?.getString("memberId"))
            MemberDetailsScreen(navHostController, memberId = memberId)
        }
    }
}