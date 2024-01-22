package com.example.timetableapp.presentation.screens.home.student

import com.example.timetableapp.domain.user_profile.model.UserProfile

sealed class HomeScreenStudentState {

    object Initial : HomeScreenStudentState()

    object IsLoading : HomeScreenStudentState()

    object ProfileResetAndNavigateToHome : HomeScreenStudentState()

    data class Error(
        val exception: Exception

    ) : HomeScreenStudentState()

    data class Result(
        val studentProfile: UserProfile.Student
    ) : HomeScreenStudentState()
}
