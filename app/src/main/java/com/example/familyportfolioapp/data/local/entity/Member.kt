package com.example.familyportfolioapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.familyportfolioapp.data.remote.model.MembersItem
import java.util.UUID


@Entity
class Member (
    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),

    var lastName: String = "",

    var firstName: String = "",
)



fun MembersItem.toMember(): Member = Member(
    id = this.id.toString(),
    lastName = lastName,
    firstName = firstName
)

fun Member.toMembersItem(): MembersItem  = MembersItem(
    id = this.id.toString(),
    lastName = lastName,
    firstName = firstName,
    createdAt = System.currentTimeMillis().toString(),
    updatedAt = System.currentTimeMillis().toString(),
)