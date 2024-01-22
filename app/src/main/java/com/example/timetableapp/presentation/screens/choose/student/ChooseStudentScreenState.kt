package com.example.timetableapp.presentation.screens.choose.student

import com.example.timetableapp.domain.timetable.model.Groups
import java.lang.Exception

sealed class ChooseStudentScreenState {

    object Initial : ChooseStudentScreenState()
    object IsLoading : ChooseStudentScreenState()

    data class Error(val exception: Exception) : ChooseStudentScreenState()


    data class Result(
        val groups: Groups
    ) : ChooseStudentScreenState()
}