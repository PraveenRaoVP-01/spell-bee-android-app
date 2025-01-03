package com.example.myapplication.domain.usecases.appentry

import com.example.myapplication.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadEmailEntry (
    private val localUserManager: LocalUserManager
) {
    operator fun invoke() : Flow<String?> = localUserManager.readEmailEntry()
}
