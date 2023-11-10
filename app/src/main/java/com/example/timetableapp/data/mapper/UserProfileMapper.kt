package com.example.timetableapp.data.mapper

import com.example.timetableapp.data.local_data_source.user_db.model.UserProfileWrapModel
import com.example.timetableapp.domain.user_profile.model.UserProfile
import javax.inject.Inject

class UserProfileMapper @Inject constructor() {
    fun wrapUserProfile(userProfile: UserProfile): UserProfileWrapModel {
        return when (userProfile) {
            is UserProfile.NotRegistered -> {
                return UserProfileWrapModel(
                    content = "NotRegistered|"
                )
            }

            is UserProfile.Student -> {
                return UserProfileWrapModel(
                    content = "Student|${userProfile.studentGroup}"
                )
            }

            is UserProfile.Teacher -> {
                return UserProfileWrapModel(
                    content = "Teacher|${userProfile.teacherName}"
                )
            }
        }
    }

    fun unWrapUserProfile(userProfileStr: UserProfileWrapModel): UserProfile {
        val userString = userProfileStr.content.split("|")
        return when (userString[0]) {
            "NotRegistered" -> {
                return UserProfile.NotRegistered
            }

            "Student" -> {
                return UserProfile.Student(
                    studentGroup = userString[1]
                )
            }

            "Teacher" -> {
                return UserProfile.Teacher(
                    teacherName = userString[1]
                )
            }

            else -> {
                return throw IllegalArgumentException("")
            }
        }
    }
}