package com.example.timetableapp.data.local_data_source

import android.content.Context
import com.example.timetableapp.data.local_data_source.user_db.UserProfileDatabase
import com.example.timetableapp.data.mapper.UserProfileMapper
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.repository.UserProfileRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserProfileRepositoryImpl @Inject constructor(
    @ApplicationContext appContext: Context,
    private val db: UserProfileDatabase,
    private val userProfileMapper: UserProfileMapper
) : UserProfileRepository {

    private val dao = db.userProfileDao
    override fun getUserProfile(): Flow<UserProfile> = flow {
        dao.getAll().collect {
            if(it.isEmpty()) {
                emit(UserProfile.NotRegistered)
            } else {
                emit(
                    userProfileMapper.unWrapUserProfile(
                        it.last()
                    )
                )
            }
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
}