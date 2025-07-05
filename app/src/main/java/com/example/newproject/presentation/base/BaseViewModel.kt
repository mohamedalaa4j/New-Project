package com.example.newproject.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<UiState, Intent, Effect> : ViewModel() {
    abstract val uiState: StateFlow<UiState>
    abstract val uiEffect: SharedFlow<Effect>
    abstract fun onIntent(intent: Intent)
    protected abstract fun showLoading()
    protected abstract fun hideLoading()
}