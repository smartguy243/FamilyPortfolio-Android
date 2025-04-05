package com.example.familyportfolioapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyportfolioapp.R
import com.example.familyportfolioapp.ui.theme.LightRed6

@Composable
fun Splash(logoAnimation: Float,  textAnimation: Float) {

    Box(modifier = Modifier
        .background(if (isSystemInDarkTheme()) Color.Black else LightRed6)
        .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {

            Text(
                modifier = Modifier
                    .alpha(alpha = textAnimation)
                    .padding(top = 65.dp),
                text = "Mukeba",
                fontWeight = FontWeight.Bold,
                fontSize = 45.sp,
                fontFamily = FontFamily.Cursive
            )

            Spacer(modifier = Modifier.width(0.dp))

            Icon(
                modifier = Modifier
                    .size(120.dp)
                    .alpha(alpha = logoAnimation),
                painter = painterResource(R.drawable.app_logo),
                contentDescription = "App_logo"
            )

            Spacer(modifier = Modifier.width(0.dp))

            Text(
                modifier = Modifier
                    .alpha(alpha = textAnimation)
                    .padding(top = 65.dp),
                text = "Family",
                fontWeight = FontWeight.Bold,
                fontSize = 45.sp,
                fontFamily = FontFamily.Cursive
            )
        }
    }

}

