package com.example.profilecardlayout.functions

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.profilecardlayout.UserInfo
import com.example.profilecardlayout.ui.theme.lightGreen200

@Composable
fun AppTopBar(label: String, icon: ImageVector, clickAction: () -> Unit) {
    TopAppBar(navigationIcon = {
        Icon(
            imageVector = icon,
            contentDescription = "Favorite",
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .clickable(onClick = clickAction)
        )
    }, title = { Text(text = label) })


}

@Composable
fun ProfileCard(userInfo: UserInfo, clickCard: () -> Unit) {
    Card(

        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable(onClick = clickCard),
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start

        ) {
            ProfilePhoto(profilePhoto = userInfo.profilePhoto, status = userInfo.status)
            ProfileContent(name = userInfo.name, status = userInfo.status)
        }
    }
}

@Composable
fun ProfilePhoto(profilePhoto: String, status: Boolean, imageSize: Dp = 72.dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (status) lightGreen200 else Color.Red
        ),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp

    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(profilePhoto)
                .crossfade(1000)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )

    }
}

@Composable
fun ProfileContent(
    name: String,
    status: Boolean,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment

    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides if (status) 1F else ContentAlpha.medium
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h5

            )
        }
        // to make text color is variance //
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = if (status) "Active Now" else "Offline",
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.body2
            )
        }
    }
}
