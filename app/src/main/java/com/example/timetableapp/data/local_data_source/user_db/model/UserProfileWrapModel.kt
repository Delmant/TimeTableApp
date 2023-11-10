package com.example.timetableapp.data.local_data_source.user_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserProfileWrapModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val content: String
)