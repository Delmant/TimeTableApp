package com.example.timetableapp.domain.user_profile.model


sealed class UserProfile {
    object NotRegistered: UserProfile()

    data class Teacher(val teacherName: String): UserProfile()

    data class Student(val studentGroup: String): UserProfile()
}