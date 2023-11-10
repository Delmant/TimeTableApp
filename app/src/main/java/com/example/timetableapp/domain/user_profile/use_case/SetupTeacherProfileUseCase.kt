package com.example.timetableapp.domain.user_profile.use_case

import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.repository.UserProfileRepository
import javax.inject.Inject

class SetupTeacherProfileUseCase @Inject constructor (private val userProfileRepository: UserProfileRepository) {
    suspend operator fun invoke(teacher: UserProfile.Teacher) =
        userProfileRepository.setupTeacherProfile(teacher)
}