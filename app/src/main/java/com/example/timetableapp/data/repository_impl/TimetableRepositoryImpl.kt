package com.example.timetableapp.data.repository_impl

import com.example.timetableapp.data.remote_data_source.TimetableRemoteDataSource
import com.example.timetableapp.domain.reaction.Reaction
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
) : TimetableRepository {
    override fun getGroups(): Flow<Reaction<Groups>> = flow {
        try {
            timetableRemoteDataSource.getGroups().collect {
                emit(
                    Reaction.Success(
                        data = it
                    )
                )
            }
        } catch (e: Exception) {
            emit(
                Reaction.Error(
                    exception = e
                )
            )
        }
    }

    override fun getTeachers(): Flow<Reaction<Teachers>> = flow {
        try {
            timetableRemoteDataSource.getTeachers().collect {
                emit(
                    Reaction.Success(
                        data = it
                    )
                )
            }
        } catch (e: Exception) {
            emit(
                Reaction.Error(
                    exception = e
                )
            )
        }
    }

    override suspend fun getTimetableGroup() {
        TODO("Not yet implemented")
    }

    override suspend fun getTimetableTeacher() {
        TODO("Not yet implemented")
    }
}