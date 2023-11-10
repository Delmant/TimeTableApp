package com.example.timetableapp.presentation.screens.navigation_handler

import com.example.timetableapp.domain.user_profile.model.UserProfile

sealed class NavigationHandlerState {

    object Initial : NavigationHandlerState()
    object IsLoading : NavigationHandlerState()

    data class Result(val userProfile: UserProfile) : NavigationHandlerState()
}
