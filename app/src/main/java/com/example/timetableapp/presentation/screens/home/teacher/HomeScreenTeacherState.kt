package com.example.timetableapp.presentation.screens.home.teacher

import com.example.timetableapp.domain.user_profile.model.UserProfile
import java.lang.Exception

sealed class HomeScreenTeacherState {
    object Initial : HomeScreenTeacherState()

    object IsLoading : HomeScreenTeacherState()

    object ProfileResetAndNavigateToHome  : HomeScreenTeacherState()

    data class Error(
        val exception: Exception
    ): HomeScreenTeacherState()

    data class Result(
        val teacherProfile: UserProfile.Teacher
    ) : HomeScreenTeacherState()
}
