package com.example.timetableapp.data.remote_data_source

import com.example.timetableapp.domain.timetable.model.Groups
import com.example.timetableapp.domain.timetable.model.Teachers
import kotlinx.coroutines.flow.Flow

interface TimetableRemoteDataSource {
    fun getGroups(): Flow<Groups>

    fun getTeachers(): Flow<Teachers>
}