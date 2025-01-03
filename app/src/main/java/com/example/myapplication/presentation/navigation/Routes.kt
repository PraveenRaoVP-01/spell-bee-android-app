package com.example.myapplication.presentation.navigation

sealed class Routes(val route: String) {
    data object OnboardingNavigation : Routes("onboarding")
    data object HomeScreen : Routes("home")
    data object LoginScreen : Routes("login")
    data object SignUpScreen : Routes("signup")
    data object ForgotPasswordScreen : Routes("forgotpassword")
    data object PostOnboardingNavigation : Routes("postonboarding")
    data object ProfileScreen : Routes("profile")
    data object GameScreen : Routes("game")
    data object DifficultySelectionScreen : Routes("difficulty")
    data object LeaderBoardScreen : Routes("leaderboard")
    data object SettingsScreen : Routes("settings")
    data object AboutScreen : Routes("about")
}