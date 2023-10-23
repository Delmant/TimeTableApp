package com.example.timetableapp.domain.user_profile.model

sealed class UserProfile {

    data class Teacher(val teacherName: String)

    data class Student(val studentGroup: String)
}