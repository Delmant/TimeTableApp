package com.example.timetableapp.domain.user_profile.repository

import com.example.timetableapp.domain.user_profile.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {
    fun getUserProfile(): Flow<UserProfile>

    suspend fun setupTeacherProfile(teacherProfile: UserProfile.Teacher)

    suspend fun setupStudentProfile(studentProfile: UserProfile.Student)
}