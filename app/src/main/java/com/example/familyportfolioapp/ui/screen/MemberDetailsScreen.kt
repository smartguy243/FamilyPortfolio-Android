package com.example.familyportfolioapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.familyportfolioapp.R
import com.example.familyportfolioapp.data.local.Database
import com.example.familyportfolioapp.navigation.AppScreen
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberDetailsScreen(navHostController: NavHostController, memberId: UUID) {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val member = Database.members.first{member -> member.id == memberId}

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = "Infos du membre",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navHostController.popBackStack()
                        }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            navHostController.navigate(AppScreen.MemberRegistration.route)
                        }) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(R.drawable.edit),
                            contentDescription = "edit"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }) { contentPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally){

            Spacer(modifier = Modifier.height(35.dp))

            Image(
                modifier = Modifier.size(180.dp),
                alignment = Alignment.Center,
                painter = painterResource(R.drawable.profile_pic),
                contentDescription = "Profile picture"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = member.firstName + " " + member.name,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = member.range,
                fontSize = 25.sp,
                fontWeight = FontWeight.W500,
                fontStyle = FontStyle.Italic,
                color = Color.DarkGray,
                textAlign = TextAlign.Center)

        }
    }
}

