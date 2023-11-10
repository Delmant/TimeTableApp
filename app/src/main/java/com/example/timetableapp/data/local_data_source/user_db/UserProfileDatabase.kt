package com.example.timetableapp.data.local_data_source.user_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.timetableapp.data.local_data_source.user_db.model.UserProfileWrapModel
import com.example.timetableapp.domain.user_profile.model.UserProfile

@Database(
    entities = [UserProfileWrapModel::class],
    version = 1
)
abstract class UserProfileDatabase: RoomDatabase() {
    abstract val userProfileDao: UserProfileDao
    companion object {
        const val USER_PROFILE_DATA_BASE_NAME = "user_profile_data_base_name.db"
    }
}