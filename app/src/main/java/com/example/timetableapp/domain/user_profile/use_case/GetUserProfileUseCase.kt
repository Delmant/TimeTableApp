package com.example.timetableapp.domain.user_profile.use_case

import com.example.timetableapp.domain.user_profile.repository.UserProfileRepository

class GetUserProfileUseCase(private val userProfileRepository: UserProfileRepository) {

    operator fun invoke() = userProfileRepository.getUserProfile()
}