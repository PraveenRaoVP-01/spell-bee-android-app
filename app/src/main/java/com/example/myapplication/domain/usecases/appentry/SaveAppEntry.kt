package com.example.myapplication.domain.usecases.appentry

import com.example.myapplication.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry() // Save the app entry value to the DataStore.
    }
}