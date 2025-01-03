package com.example.myapplication.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    suspend fun saveAppEntry(entry: Boolean) // save the app entry i.e if the user is logging for the first time or not

    suspend fun saveEmail(email: String)

    fun readAppEntry(): Flow<Boolean> // read the app entry value from the DataStore

    fun readEmailEntry(): Flow<String?>
}
