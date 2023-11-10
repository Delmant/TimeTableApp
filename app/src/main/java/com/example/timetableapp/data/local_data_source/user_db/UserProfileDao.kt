package com.example.timetableapp.data.local_data_source.user_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.timetableapp.data.local_data_source.user_db.model.UserProfileWrapModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProfileDao {

    @Upsert
    suspend fun insertUserProfile(userProfileWrapModel: UserProfileWrapModel)

    @Query("DELETE FROM UserProfileWrapModel")
    suspend fun clearUserProfile()

    @Query("SELECT * FROM UserProfileWrapModel WHERE id = :id")
     fun getUserProfile(id: Int): Flow<UserProfileWrapModel>

    @Query("SELECT * FROM UserProfileWrapModel")
     fun getAll(): Flow<List<UserProfileWrapModel>>
}