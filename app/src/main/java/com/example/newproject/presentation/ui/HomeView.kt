package com.example.newproject.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.newproject.presentation.model.HomeState

@Composable
fun HomeView(state: HomeState) {
    Text(
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
        text = state.products?.products?.get(0)?.title.orEmpty()
    )
}