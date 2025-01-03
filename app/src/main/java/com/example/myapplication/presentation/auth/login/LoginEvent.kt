package com.example.myapplication.presentation.auth.login

sealed interface LoginEvent {
    data class EmailChanged(val value: String) : LoginEvent
    data class PasswordChanged(val value: String) : LoginEvent
    data object Login : LoginEvent
    data object ClearErrorFields : LoginEvent
}