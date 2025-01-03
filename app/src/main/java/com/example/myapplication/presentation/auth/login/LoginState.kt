package com.example.myapplication.presentation.auth.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isError: Boolean = false,
    val error: String = "",
    val isLoading: Boolean = false,
)