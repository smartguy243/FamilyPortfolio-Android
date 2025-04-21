package com.godsonpeya.myfamily.navigation

sealed class AppScreen(val route: String) {

    data object Splash : AppScreen("splash")

    data object MemberList : AppScreen("member_list")

    data object Detail : AppScreen("detail/{memberId}") {
        fun createRoute(memberId: String) = "detail/$memberId"
    }


}