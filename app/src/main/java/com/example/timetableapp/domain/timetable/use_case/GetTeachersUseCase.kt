package com.example.timetableapp.domain.timetable.use_case

import com.example.timetableapp.domain.timetable.repository.TimetableRepository

class GetTeachersUseCase(private val timetableRepository: TimetableRepository) {
    operator fun invoke() = timetableRepository.getTeachers()
}