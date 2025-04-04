package com.example.familyportfolioapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.familyportfolioapp.R
import com.example.familyportfolioapp.data.model.Member

@Composable
fun MemberCard(member: Member, onMemberClicked: () -> Unit) {
    Spacer(modifier = Modifier.height(20.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(15.dp))

        Image(
            painter = painterResource(R.drawable.profile_pic),
            modifier = Modifier.size(100.dp),
            contentDescription = "profile_pic"
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onMemberClicked() }) {

            Text(
                text = member.firstName + " " + member.name,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = member.range,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}