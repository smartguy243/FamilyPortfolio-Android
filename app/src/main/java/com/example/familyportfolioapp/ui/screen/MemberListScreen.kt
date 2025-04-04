package com.example.familyportfolioapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyportfolioapp.R
import com.example.familyportfolioapp.data.local.Database
import com.example.familyportfolioapp.data.model.Member
import com.example.familyportfolioapp.ui.components.MemberCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemberListScreen() {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val members = Database.members

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
                        text = "Membres",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.home),
                            contentDescription = "back"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }) { contentPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxWidth()) {

            items(members){ member ->

                MemberCard(member)

            }

        }


    }
}