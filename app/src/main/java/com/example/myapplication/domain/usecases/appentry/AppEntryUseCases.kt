package com.example.myapplication.domain.usecases.appentry

data class AppEntryUsecases(
    val saveAppEntry: SaveAppEntry,
    val readAppEntry: ReadAppEntry,
    val saveEmailEntry: SaveEmailEntry,
    val readEmailEntry: ReadEmailEntry
)