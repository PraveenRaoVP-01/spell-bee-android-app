package com.example.myapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecases.appentry.AppEntryUsecases
import com.example.myapplication.presentation.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases : AppEntryUsecases
) : ViewModel() {
    var startDestination by mutableStateOf(Routes.OnboardingNavigation.route)
        private set

    var splashCondition by mutableStateOf(true)
        private set

    init {
        viewModelScope.launch {
            appEntryUseCases.readAppEntry().collect {
                startDestination = if (it) {
                    Routes.PostOnboardingNavigation.route
                } else {
                    Routes.OnboardingNavigation.route
                }
                splashCondition = false
            }
        }
    }

}