package com.example.timetableapp.domain.user_profile.use_case

import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.repository.UserProfileRepository

class SetupTeacherProfileUseCase(private val userProfileRepository: UserProfileRepository) {
    operator fun invoke(teacher: UserProfile.Teacher) =
        userProfileRepository.setupTeacherProfile(teacher)
}