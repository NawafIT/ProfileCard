package com.example.profilecardlayout.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.profilecardlayout.UserInfo
import com.example.profilecardlayout.screenA.UserProfilePreview
import com.example.profilecardlayout.screenB.UserProfileDetail
import com.example.profilecardlayout.userProfileList

@Composable
fun Nav(userInfo: List<UserInfo> = userProfileList) {
    val navHostController: NavHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "UserProfilePreview") {
        composable(route = "UserProfilePreview") {
            UserProfilePreview(userInfo = userInfo, navHostController = navHostController)
        }
        composable(
            route = "UserProfileDetail/{userId}",
            arguments = listOf(navArgument(name = "userId") {
                type = NavType.IntType
            })

        ) { NavBackStackEntry ->
            UserProfileDetail(NavBackStackEntry.arguments!!.getInt("userId"),navHostController )
        }
    }
}