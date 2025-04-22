package com.example.familyportfolioapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NoDataFound() {
    Box {
        Text(
            text = "No member found",
            modifier = Modifier.Companion.align(Alignment.Companion.Center)
        )
    }
}