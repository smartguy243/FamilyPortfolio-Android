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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.familyportfolioapp.R
import com.example.familyportfolioapp.data.remote.model.MembersItemRq
import com.example.familyportfolioapp.ui.components.MemberAlertDialog
import com.example.familyportfolioapp.ui.components.MemberFormDialog
import com.example.familyportfolioapp.ui.components.NoDataFound
import com.example.familyportfolioapp.viewmodel.MemberViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navHostController: NavHostController,
    memberId: String,
    viewModel: MemberViewModel = hiltViewModel()
) {


    var openEditDialog by remember { mutableStateOf(false) }
    var openAlertDialog by remember { mutableStateOf(false) }

    val member by viewModel.member.collectAsState()

    LaunchedEffect(key1 = memberId) {
        viewModel.getMember(memberId)

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
                    IconButton(onClick = {
                        openEditDialog = !openEditDialog
                    }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                    IconButton(onClick = {
                        openAlertDialog = !openAlertDialog
                    }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(30.dp))

            if (member == null) {
                NoDataFound()
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.profile_pic),
                        contentDescription = "Profile",
                        modifier = Modifier.size(130.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "${member?.firstName} ${member?.lastName}",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center)
                }
            }
        }

        if (openEditDialog) {
            MemberFormDialog(
                member = member,
                action = "Update",
                onCancel = {
                    openEditDialog = !openEditDialog
                },
                onConfirm = { firstname, lastname ->
                    viewModel.updateMember(
                        id = memberId,
                        member = MembersItemRq(
                            id = memberId,
                            firstName = firstname,
                            lastName = lastname
                        )
                    )
                    viewModel.getMember(id = memberId)
                    openEditDialog = !openEditDialog
                })
        }

        if (openAlertDialog) {
            MemberAlertDialog(
                onCancel = {
                    openAlertDialog = !openAlertDialog
                },
                onConfirm = {
                    viewModel.deleteMember(id = memberId)
                    navHostController.popBackStack()
                })
        }
    }


}