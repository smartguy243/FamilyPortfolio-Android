package com.example.familyportfolioapp.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.familyportfolioapp.data.remote.model.MembersItemRq
import com.example.familyportfolioapp.ui.components.MemberCard
import com.example.familyportfolioapp.viewmodel.MemberViewModel
import com.godsonpeya.myfamily.navigation.AppScreen
import com.example.familyportfolioapp.ui.components.MemberFormDialog
import com.example.familyportfolioapp.ui.components.NoDataFound


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: MemberViewModel = hiltViewModel()) {


    val members by viewModel.members.collectAsState()

    var openAlertDialog by remember { mutableStateOf(false) }


    LaunchedEffect(key1 = Unit) {
        viewModel.getMembers()
    }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(
                        text = "Members",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis)
                },
                actions = {
                    IconButton(onClick = {
                        openAlertDialog = !openAlertDialog
                    }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { padding ->
        if (members.isEmpty()) {
            NoDataFound()
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth()) {

                items(members) { member ->

                    MemberCard(
                        member,
                        onMemberClicked = {
                            navController.navigate(AppScreen.Detail.createRoute(member.id))
                        })
                }
            }
        }

    }

    if (openAlertDialog) {
        MemberFormDialog(
            onCancel = {
                openAlertDialog = !openAlertDialog
            },
            onConfirm = { firstname, lastname ->
                viewModel.addMember(MembersItemRq(firstName = firstname, lastName = lastname))
                viewModel.getMembers()
                openAlertDialog = !openAlertDialog
            })
    }
}

