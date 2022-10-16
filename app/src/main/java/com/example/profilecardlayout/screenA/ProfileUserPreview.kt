package com.example.profilecardlayout.screenA

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

import com.example.profilecardlayout.UserInfo
import com.example.profilecardlayout.functions.AppTopBar
import com.example.profilecardlayout.functions.ProfileCard

import com.example.profilecardlayout.ui.theme.veryLightGrey

@Composable
fun UserProfilePreview(
    userInfo: List<UserInfo>,
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            AppTopBar(
                label = "Profile Preview",
                icon = Icons.Default.Person
            ) {}
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = veryLightGrey
        ) {
            LazyColumn {
                items(userInfo) { user ->
                    ProfileCard(user) {
                        navHostController.navigate(
                            route = "UserProfileDetail/${user.id}"
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun UserPreview() {
//    UserProfilePreview()
}