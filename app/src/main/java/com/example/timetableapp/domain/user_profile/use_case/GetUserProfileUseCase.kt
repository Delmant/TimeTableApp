package com.example.timetableapp.domain.user_profile.use_case

import com.example.timetableapp.domain.user_profile.repository.UserProfileRepository
import javax.inject.Inject


class GetUserProfileUseCase @Inject constructor(private val userProfileRepository: UserProfileRepository) {

    operator fun invoke() = userProfileRepository.getUserProfile()
}