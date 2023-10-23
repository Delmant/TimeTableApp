package com.example.timetableapp.domain.user_profile.repository

import com.example.timetableapp.domain.user_profile.model.UserProfile

interface UserProfileRepository {
    fun getUserProfile(): UserProfile

    fun setupTeacherProfile(teacherProfile: UserProfile.Teacher)

    fun setupStudentProfile(studentProfile: UserProfile.Student)
}