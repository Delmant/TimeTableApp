package com.example.timetableapp.domain.timetable.use_case

import com.example.timetableapp.domain.timetable.repository.TimetableRepository

class GetTimetableGroupUseCase(private val timetableRepository: TimetableRepository) {
    operator fun invoke() = timetableRepository.getTimetableGroup()
}