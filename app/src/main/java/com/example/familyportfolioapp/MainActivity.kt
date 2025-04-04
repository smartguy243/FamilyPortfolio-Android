package com.example.familyportfolioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.familyportfolioapp.ui.theme.FamilyPortfolioAppTheme
import com.example.familyportfolioapp.ui.screen.MemberListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FamilyPortfolioAppTheme {
                MemberListScreen()
            }
        }
    }
}
