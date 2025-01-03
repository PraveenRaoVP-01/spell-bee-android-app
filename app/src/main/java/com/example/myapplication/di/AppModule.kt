package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.data.manager.LocalUserManagerImpl
import com.example.myapplication.domain.manager.LocalUserManager
import com.example.myapplication.domain.usecases.appentry.AppEntryUsecases
import com.example.myapplication.domain.usecases.appentry.ReadAppEntry
import com.example.myapplication.domain.usecases.appentry.ReadEmailEntry
import com.example.myapplication.domain.usecases.appentry.SaveAppEntry
import com.example.myapplication.domain.usecases.appentry.SaveEmailEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUsecases(
        localUserManager: LocalUserManager
    ) = AppEntryUsecases(
        saveAppEntry = SaveAppEntry(localUserManager),
        readAppEntry = ReadAppEntry(localUserManager),
        saveEmailEntry = SaveEmailEntry(localUserManager),
        readEmailEntry = ReadEmailEntry(localUserManager)
    )


}