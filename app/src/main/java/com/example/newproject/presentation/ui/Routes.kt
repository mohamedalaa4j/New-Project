package com.example.newproject.presentation.ui

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object HomeScreen : Routes()

    @Serializable
    object History : Routes()
}