package com.example.timetableapp.domain.timetable.use_case

import com.example.timetableapp.domain.timetable.repository.TimetableRepository

class GetTimetableTeacherUseCase(private val timetableRepository: TimetableRepository) {
    operator fun invoke() = timetableRepository.getTimetableTeacher()
}