package com.example.myapplication

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapplication.presentation.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases : AppEntryUseCases
) : ViewModel() {
    var startDestination by mutableStateOf(Routes.OnboardingNavigation.route)
        private set

    var splashCondition by mutableStateOf(true)
        private set

    init {

    }

}