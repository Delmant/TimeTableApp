package com.example.timetableapp.data.local_data_source

import com.example.timetableapp.data.local_data_source.user_db.UserProfileDatabase
import com.example.timetableapp.data.mapper.UserProfileMapper
import com.example.timetableapp.domain.reaction.Reaction
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.repository.UserProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserProfileRepositoryImpl @Inject constructor(
    db: UserProfileDatabase,
    private val userProfileMapper: UserProfileMapper
) : UserProfileRepository {

    private val dao = db.userProfileDao
    override fun getUserProfile(): Flow<Reaction<UserProfile>> = flow {
        try {
            dao.getUserProfile(id = USER_PROFILE_BASE_ID).collect {
                if (it != null) {
                    emit(
                        Reaction.Success(
                            userProfileMapper.unWrapUserProfile(
                                it
                            )
                        )
                    )
                } else {
                    emit(
                        Reaction.Success(
                            UserProfile.NotRegistered
                        )
                    )
                }
            }
        } catch (e: Exception) {
            emit(Reaction.Error(e))
        }
    }

    override suspend fun setupTeacherProfile(teacherProfile: UserProfile.Teacher) {
        dao.clearUserProfile()
        dao.insertUserProfile(
            userProfileMapper.wrapUserProfile(teacherProfile)
        )
    }

    override suspend fun setupStudentProfile(studentProfile: UserProfile.Student) {
        dao.clearUserProfile()
        dao.insertUserProfile(
            userProfileMapper.wrapUserProfile(studentProfile)
        )
    }

    override suspend fun resetUserProfile() {
        dao.clearUserProfile()
        dao.insertUserProfile(
            userProfileMapper.wrapUserProfile(UserProfile.NotRegistered)
        )
    }

    companion object {
        private const val USER_PROFILE_BASE_ID = 0
    }
}