package com.example.newproject.presentation.screen.home.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeView(){
    Text(
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
        text = "Home"
    )
}