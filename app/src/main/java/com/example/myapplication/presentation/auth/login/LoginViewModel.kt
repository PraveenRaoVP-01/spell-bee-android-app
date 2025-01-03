package com.example.myapplication.presentation.auth.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecases.appentry.AppEntryUsecases
import com.example.myapplication.ext.isValidEmail
import com.example.myapplication.presentation.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val appEntryUsecases: AppEntryUsecases
) : ViewModel() {
    val uiState = mutableStateOf(LoginState())

    init {
        viewModelScope.launch {
            appEntryUsecases.readEmailEntry().collect {
                if (it != null) {
                    uiState.value = uiState.value.copy(email = it)
                }
            }
        }
    }

    fun onEmailChanged(email: String) {
        uiState.value = uiState.value.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        uiState.value = uiState.value.copy(password = password)
    }

    fun clearErrorFields() {
        uiState.value =
            uiState.value.copy(isEmailError = false, isPasswordError = false, error = "")
    }

    fun onEvent(
        event: LoginEvent,
        navigatePopTo: (String, String) -> Unit = { _, _ -> }
    ) {
        CoroutineScope(viewModelScope.coroutineContext).launch {
            when (event) {
                LoginEvent.ClearErrorFields -> clearErrorFields()
                is LoginEvent.EmailChanged -> onEmailChanged(event.email)
                LoginEvent.Login -> login(navigatePopTo)
                is LoginEvent.PasswordChanged -> onPasswordChanged(event.password)
            }
        }
    }

    suspend fun login(navigatePopTo: (String, String) -> Unit) {
        if (uiState.value.email.isEmpty()) {
            uiState.value = uiState.value.copy(isEmailError = true, error = "Email is required")
            return
        }

        if (uiState.value.password.isEmpty()) {
            uiState.value =
                uiState.value.copy(isPasswordError = true, error = "Password is required")
            return
        }

        if (!uiState.value.email.isValidEmail()) {
            uiState.value = uiState.value.copy(isEmailError = true, error = "Invalid email")
            return
        }

        appEntryUsecases.saveEmailEntry(uiState.value.email)
        appEntryUsecases.saveAppEntry(true)


        // Login logic
        navigatePopTo(Routes.PostOnboardingNavigation.route, Routes.OnboardingNavigation.route)
    }

}