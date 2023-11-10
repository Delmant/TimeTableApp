package com.example.timetableapp.data.remote_data_source

import com.example.timetableapp.domain.timetable.model.Groups
import com.example.timetableapp.domain.timetable.model.Teachers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TimetableRemoteDataSourceImpl @Inject constructor(

):TimetableRemoteDataSource {
    override fun getGroups(): Flow<Groups> {
        return flow {
            val list = mutableListOf<String>()
            repeat(15) {
                list.add("БГТ-${100 + it}")
            }
            emit(
                Groups(
                    groups = list
                )
            )
        }
    }

    override fun getTeachers(): Flow<Teachers> {
        return flow {
            val list = mutableListOf<String>()
            repeat(15) {
                list.add("Бебурах А.${'A' + it}")
            }
            emit(
                Teachers(
                    teachers = list
                )
            )
        }
    }
}