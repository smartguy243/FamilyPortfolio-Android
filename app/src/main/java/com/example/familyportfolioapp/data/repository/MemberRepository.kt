package com.example.familyportfolioapp.data.repository

import android.util.Log
import com.example.familyportfolioapp.data.remote.FamilyService
import com.example.familyportfolioapp.data.remote.model.MembersItem
import com.example.familyportfolioapp.data.remote.model.MembersItemRq
import com.example.familyportfolioapp.data.local.dao.MemberDao
import com.example.familyportfolioapp.data.local.entity.toMember
import com.example.familyportfolioapp.data.local.entity.toMembersItem
import javax.inject.Inject

class MemberRepository @Inject constructor(
    private val familyService: FamilyService,
    private val memberDao: MemberDao
) {

    suspend fun getMembers(): List<MembersItem> {
        return try {
            val remoteMembers = familyService.getMembers()
            // Insérer les membres distants dans la base locale
            memberDao.insertMembers(*remoteMembers.map { it.toMember() }.toTypedArray())
            memberDao.getMembers().map { it.toMembersItem() }
        } catch (e: Exception) {
            Log.e(MemberRepository::class.java.toString(), "Il n'y a pas d'internet ${e.message}")
            memberDao.getMembers().map { it.toMembersItem() }
        }
    }

    suspend fun getMember(id: String): MembersItem {
        return familyService.getMember(id)
    }

    suspend fun addMember(member: MembersItemRq): MembersItem {
        val newMember = familyService.saveMember(member)
        // Ajouter le nouveau membre dans la base locale
        memberDao.insertMembers(newMember.toMember())
        return newMember
    }

    suspend fun updateMember(id: String, member: MembersItemRq): MembersItem {
        val updatedMember = familyService.updateMember(id, member)
        // Mettre à jour le membre dans la base locale
        memberDao.updateMember(updatedMember.toMember())
        return updatedMember
    }

    suspend fun deleteMember(id: String): String {
        val result = familyService.deleteMember(id)
        // Supprimer le membre de la base locale
        memberDao.deleteMember(memberDao.getMember(id))
        return result
    }
}