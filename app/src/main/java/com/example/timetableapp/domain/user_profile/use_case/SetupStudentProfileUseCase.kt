package com.example.timetableapp.domain.user_profile.use_case

import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.repository.UserProfileRepository

class SetupStudentProfileUseCase(private val userProfileRepository: UserProfileRepository) {
    operator fun invoke(student: UserProfile.Student) =
        userProfileRepository.setupStudentProfile(student)
}