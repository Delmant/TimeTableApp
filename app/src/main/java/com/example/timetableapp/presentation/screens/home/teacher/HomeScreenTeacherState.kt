package com.example.timetableapp.presentation.screens.home.teacher

import com.example.timetableapp.domain.user_profile.model.UserProfile

sealed class HomeScreenTeacherState {
    object Initial : HomeScreenTeacherState()

    object IsLoading : HomeScreenTeacherState()

    data class Result(
        val teacherProfile: UserProfile.Teacher
    ) : HomeScreenTeacherState()
}
