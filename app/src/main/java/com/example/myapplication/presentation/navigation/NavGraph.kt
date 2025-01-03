package com.example.myapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.myapplication.presentation.auth.login.LoginScreen
import com.example.myapplication.presentation.auth.login.LoginViewModel

@Composable
fun NavGraph(startDestination: String, modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            startDestination = Routes.LoginScreen.route,
            route = Routes.OnboardingNavigation.route
        ) {
            composable(route = Routes.LoginScreen.route) {
                val viewModel: LoginViewModel = hiltViewModel()
                LoginScreen(
                    state = viewModel.uiState.value,
                    navigateTo = { route -> navigateTo(route, navController) },
                    navigatePopTo = { route, popUp ->
                        navigateAndPopUp(route, popUp, navController)
                    },
                    onEvent = viewModel::onEvent
                )
            }
        }

        navigation(startDestination = Routes.HomeScreen.route, route = Routes.PostOnboardingNavigation.route) {
            composable(route = Routes.HomeScreen.route) {
                // HomeScreen()
            }
        }
    }
}

fun navigateTo(route: String, navHostController: NavHostController) {
    navHostController.navigate(route)
}

fun navigateAndPopUp(route: String, popUp: String, navHostController: NavHostController) {
    navHostController.navigate(route) {
        popUpTo(popUp) {
            inclusive = true
        }
    }
}