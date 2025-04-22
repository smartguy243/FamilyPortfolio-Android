package com.example.familyportfolioapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun NoDataFound() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "No member found",
            fontSize = 30.sp,
            fontWeight = FontWeight.W600,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            color = Color.Gray,
            modifier = Modifier.Companion.align(Alignment.Companion.Center)
        )
    }
}