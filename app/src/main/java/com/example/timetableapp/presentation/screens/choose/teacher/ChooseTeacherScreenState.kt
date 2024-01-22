package com.example.timetableapp.presentation.screens.choose.teacher

import com.example.timetableapp.domain.timetable.model.Teachers
import java.lang.Exception

sealed class ChooseTeacherScreenState {
    object Initial : ChooseTeacherScreenState()

    object IsLoading : ChooseTeacherScreenState()

    data class Error(
        val exception: Exception
    ) : ChooseTeacherScreenState()

    data class Result(
        val teachers: Teachers
    ) : ChooseTeacherScreenState()
}
