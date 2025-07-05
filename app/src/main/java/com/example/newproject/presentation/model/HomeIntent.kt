package com.example.newproject.presentation.model

sealed interface HomeIntent {
    data class OnCommentsClick (val postId:Int) :HomeIntent
}