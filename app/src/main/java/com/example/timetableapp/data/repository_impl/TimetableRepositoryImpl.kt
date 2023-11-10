package com.example.timetableapp.data.repository_impl

import com.example.timetableapp.data.remote_data_source.TimetableRemoteDataSource
import com.example.timetableapp.domain.timetable.model.Groups
import com.example.timetableapp.domain.timetable.model.Teachers
import com.example.timetableapp.domain.timetable.repository.TimetableRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TimetableRepositoryImpl @Inject constructor(
    private val timetableRemoteDataSource: TimetableRemoteDataSource
): TimetableRepository {
    override fun getGroups(): Flow<Groups> = flow {
        delay(5000)
        timetableRemoteDataSource.getGroups().collect{
            emit(it)
        }
    }

    override fun getTeachers(): Flow<Teachers> = flow {
        delay(5000)
        timetableRemoteDataSource.getTeachers().collect {
            emit(it)
        }
    }

    override suspend fun getTimetableGroup() {
        TODO("Not yet implemented")
    }

    override suspend fun getTimetableTeacher() {
        TODO("Not yet implemented")
    }
}