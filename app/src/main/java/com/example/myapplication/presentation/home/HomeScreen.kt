package com.example.myapplication.presentation.home

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.presentation.common.BasicButton
import com.example.myapplication.presentation.navigation.navigateAndPopUp

@Composable
fun HomeScreen(
    onClick : ((String, String) -> Unit) -> Unit,
    navigatePopTo: (String, String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicButton(text = R.string.logout, action = { onClick(navigatePopTo) }, modifier = Modifier)
    }
}