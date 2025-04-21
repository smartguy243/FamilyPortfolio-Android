package com.example.familyportfolioapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.familyportfolioapp.data.remote.model.MembersItem

@Composable
fun MemberFormDialog(
    member: MembersItem? = null,
    action: String = "Add",
    onCancel: () -> Unit = {},
    onConfirm: (
        firstname: String,
        lastname: String,
    ) -> Unit
) {
    var firstname by remember { mutableStateOf(member?.firstName ?: "") }
    var lastname by remember { mutableStateOf(member?.lastName ?: "") }
    Dialog(onDismissRequest = { }) {
        Card(
            modifier = Modifier.Companion.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
        ) {

            Column(
                modifier = Modifier.Companion
                    .padding(16.dp)
                    .fillMaxWidth(),
            ) {
                OutlinedTextField(value = firstname, onValueChange = {
                    firstname = it
                }, label = {
                    Text(text = "First name")
                })
                OutlinedTextField(value = lastname, onValueChange = {
                    lastname = it
                }, label = {
                    Text(text = "Last name")
                })
                Row(
                    modifier = Modifier.Companion.fillMaxWidth(),
                    verticalAlignment = Alignment.Companion.CenterVertically,
                    horizontalArrangement = Arrangement.End

                ) {
                    Button(
                        onClick = {
                            onCancel()
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                        )
                    ) {
                        Text(text = "Cancel")
                    }
                    Spacer(modifier = Modifier.Companion.width(16.dp))
                    Button(onClick = {
                        onConfirm(firstname, lastname)
                    }) {
                        Text(text = action)
                    }
                }
            }

        }
    }
}