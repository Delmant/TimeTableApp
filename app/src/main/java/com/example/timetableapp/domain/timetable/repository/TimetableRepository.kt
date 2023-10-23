package com.example.timetableapp.domain.timetable.repository

interface TimetableRepository {

    fun getGroups()

    fun getTeachers()

    fun getTimetableGroup()

    fun getTimetableTeacher()
}