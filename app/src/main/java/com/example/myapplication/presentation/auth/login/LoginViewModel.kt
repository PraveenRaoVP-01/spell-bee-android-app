package com.example.myapplication.presentation.auth.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {
    val uiState = mutableStateOf(LoginState())

    fun onEvent(
        event: LoginEvent,
        navigatePopTo: (String, String) -> Unit = {_,_ ->}
    ) {
        when (event) {
            LoginEvent.ClearErrorFields -> TODO()
            is LoginEvent.EmailChanged -> TODO()
            LoginEvent.Login -> TODO()
            is LoginEvent.PasswordChanged -> TODO()
        }
    }

}