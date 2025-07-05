package com.example.newproject.presentation.model

import com.example.newproject.utiles.state.UiText

sealed interface HomeEffect {
    data class ShowErrorDialog(val message: UiText) : HomeEffect
    data class NavigateToCommentsScreen(val postId: Int) : HomeEffect
}