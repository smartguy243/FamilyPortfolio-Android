package com.example.familyportfolioapp.navigation

sealed class AppScreen(var route: String) {

    data object AnimatedSplash:AppScreen("animated_splash")
    data object MemberRegistration:AppScreen("member_registration")
    data object MemberList:AppScreen("member_list")
    data object MemberDetails:AppScreen("member_details")
}