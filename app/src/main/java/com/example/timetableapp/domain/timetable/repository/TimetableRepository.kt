package com.example.timetableapp.domain.timetable.repository

import com.example.timetableapp.domain.reaction.Reaction
import com.example.timetableapp.domain.timetable.model.Groups
import com.example.timetableapp.domain.timetable.model.Teachers
import kotlinx.coroutines.flow.Flow

interface TimetableRepository {

    fun getGroups(): Flow<Reaction<Groups>>

    fun getTeachers(): Flow<Reaction<Teachers>>

    suspend fun getTimetableGroup()

    suspend fun getTimetableTeacher()
}