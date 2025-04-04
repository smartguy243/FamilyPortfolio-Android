package com.example.familyportfolioapp.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyportfolioapp.R

@Composable
fun RegistrationScreen(){

    var firstName by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var range by remember { mutableStateOf("") }


    Scaffold(
        modifier = Modifier.fillMaxSize()) { innerPadding ->

        Column(Modifier.padding(innerPadding).fillMaxSize()){

            Spacer(modifier = Modifier.height(20.dp))

            Row(Modifier.fillMaxWidth().padding(end = 20.dp),
                horizontalArrangement = Arrangement.Absolute.Right) {
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(12.dp),
                    enabled = true,
                ) {
                    Text("Membres")

                    Spacer(modifier = Modifier.width(10.dp))

                    Icon(
                        modifier = Modifier.size(15.dp).rotate(180f),
                        painter = painterResource(R.drawable.left_arrow),
                        contentDescription = "arrow")
                }
            }

            Spacer(modifier = Modifier.height(70.dp))

            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally){

                Image(
                    modifier = Modifier.size(120.dp),
                    painter = painterResource(R.drawable.app_logo),
                    contentDescription = "app_logo")

                Spacer(modifier = Modifier.height(45.dp))

                Text(text = "Ajouter un membre",
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(30.dp))

                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = {
                        Text(
                            text = "Prenom",
                            fontStyle = FontStyle.Italic)
                    },
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = {
                        Text(
                            text = "Nom",
                            fontStyle = FontStyle.Italic)
                    },
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = range,
                    onValueChange = { range = it },
                    label = {
                        Text(
                            text = "Rang",
                            fontStyle = FontStyle.Italic)
                    },
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    onClick = { },
                    shape = RoundedCornerShape(12.dp),
                    enabled = (firstName.isNotEmpty() && name.isNotEmpty() && range.isNotEmpty()),
                ) {
                    Text(
                        text ="Ajouter",
                        )
                }
            }

            Spacer(modifier = Modifier.height(100.dp))

            Row(Modifier.fillMaxWidth().padding(end = 20.dp),
                horizontalArrangement = Arrangement.Absolute.Right){
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {  },
                    painter = painterResource(R.drawable.info_ic),
                    contentDescription = "about us")
            }

        }
    }
}