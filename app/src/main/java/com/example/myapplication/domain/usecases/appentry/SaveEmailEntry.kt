package com.example.myapplication.domain.usecases.appentry

import com.example.myapplication.domain.manager.LocalUserManager

class SaveEmailEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(email: String) {
        localUserManager.saveEmail(email)
    }
}
