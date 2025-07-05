package com.example.newproject.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.newproject.R
import com.example.newproject.domain.usecase.GetProductsUseCase
import com.example.newproject.presentation.base.BaseViewModel
import com.example.newproject.presentation.model.HomeEffect
import com.example.newproject.presentation.model.HomeIntent
import com.example.newproject.presentation.model.HomeState
import com.example.newproject.utiles.state.Resource
import com.example.newproject.utiles.state.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : BaseViewModel<HomeState, HomeIntent, HomeEffect>() {

    private var _uiState = MutableStateFlow(HomeState())
    override val uiState: StateFlow<HomeState> get() = _uiState

    private var _uiEffect = MutableSharedFlow<HomeEffect>()
    override val uiEffect: SharedFlow<HomeEffect> get() = _uiEffect

    init {
        getProducts()
    }

    override fun onIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.OnCommentsClick -> {
                navigateToCommentsScreen(intent.postId)
            }
        }
    }

    override fun showLoading() {
        _uiState.update {
            it.copy(isLoading = true)
        }
    }

    override fun hideLoading() {
        _uiState.update {
            it.copy(isLoading = false)
        }
    }

    private fun getProducts() {
        viewModelScope.launch {
            withContext(coroutineContext) {
                getProductsUseCase().collect { result ->
                    when (result) {
                        is Resource.Loading -> {
                            showLoading()
                        }
                        is Resource.Success -> {
                            hideLoading()
                            _uiState.update {
                                it.copy(products = result.data)
                            }
                        }
                        is Resource.Error -> {
                            hideLoading()
                            _uiEffect.emit(
                                HomeEffect.ShowErrorDialog(
                                    result.message ?: UiText.StringResource(R.string.something_went_wrong)
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    private fun navigateToCommentsScreen(postId: Int) {
        viewModelScope.launch {
            _uiEffect.emit(HomeEffect.NavigateToCommentsScreen(postId))
        }
    }
}