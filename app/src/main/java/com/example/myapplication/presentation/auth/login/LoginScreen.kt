package com.example.myapplication.presentation.auth.login

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.presentation.common.BasicButton
import com.example.myapplication.presentation.common.BasicTextButton
import com.example.myapplication.presentation.common.EmailField
import com.example.myapplication.presentation.common.PasswordField
import com.example.myapplication.presentation.navigation.Routes

@Composable
fun LoginScreen(
    navigateTo: (String) -> Unit,
    navigatePopTo: (String, String) -> Unit,
    state: LoginState,
    onEvent: (LoginEvent, (String, String) -> Unit) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", fontSize = TextUnit(24F, TextUnitType.Sp))
        // Email
        Spacer(modifier = Modifier.height(16.dp))
        EmailField(value = state.email, onNewValue = { onEvent(LoginEvent.EmailChanged(it), {_,_->})}, isError = state.isEmailError)
        Spacer(modifier = Modifier.height(16.dp))
        // Password
        PasswordField(value = state.password, onNewValue = { onEvent(LoginEvent.PasswordChanged(it), {_,_->})}, isError = state.isPasswordError)
        Spacer(modifier = Modifier.height(16.dp))
        // Login Button
        BasicButton(
            text = R.string.login, action = { onEvent(LoginEvent.Login, navigatePopTo) },
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Error Text
        if(state.isEmailError || state.isPasswordError) {
            Text(text = state.error, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.error)
        }

        BasicTextButton(
            text = R.string.forgot_password, modifier = Modifier, onClick = { navigateTo(Routes.ForgotPasswordScreen.route) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextButton(
            text = R.string.sign_up, modifier = Modifier, onClick = { navigateTo(Routes.SignUpScreen.route) }
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navigateTo = {}, navigatePopTo = { _, _ -> }, state = LoginState(), onEvent = {_,_->})
}