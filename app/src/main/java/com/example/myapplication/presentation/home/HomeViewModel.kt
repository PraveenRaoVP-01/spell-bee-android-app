package com.example.myapplication.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecases.appentry.AppEntryUsecases
import com.example.myapplication.presentation.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUsecases
) : ViewModel() {

    fun onClick(navigatePopTo: (String, String) -> Unit) {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry(false)
        }
        navigatePopTo(Routes.OnboardingNavigation.route, Routes.PostOnboardingNavigation.route)
    }
}