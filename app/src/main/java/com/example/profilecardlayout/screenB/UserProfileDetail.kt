package com.example.profilecardlayout.screenB

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.profilecardlayout.*
import com.example.profilecardlayout.functions.AppTopBar
import com.example.profilecardlayout.functions.ProfileContent
import com.example.profilecardlayout.functions.ProfilePhoto
import com.example.profilecardlayout.ui.theme.veryLightGrey

@Composable
fun UserProfileDetail(userId: Int, navHostController: NavHostController) {
    val userInfo = userProfileList.first { it.id == userId }
    Scaffold(
        topBar = {
            AppTopBar(
                label = "User detail",
                icon = Icons.Default.ArrowBack
            ) {
                // to back to previous Screen //
                navHostController.navigateUp()
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = veryLightGrey
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                ProfilePhoto(
                    profilePhoto = userInfo.profilePhoto,
                    status = userInfo.status,
                    imageSize = 240.dp
                )
                ProfileContent(
                    name = userInfo.name,
                    status = userInfo.status,
                    alignment = Alignment.CenterHorizontally
                )
            }
        }
    }
}

@Preview
@Composable
fun UserDetail() {

}