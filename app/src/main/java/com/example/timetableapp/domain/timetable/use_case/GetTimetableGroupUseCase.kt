package com.example.timetableapp.domain.timetable.use_case

import com.example.timetableapp.domain.timetable.repository.TimetableRepository
import javax.inject.Inject

class GetTimetableGroupUseCase @Inject constructor(private val timetableRepository: TimetableRepository) {
    suspend operator fun invoke() = timetableRepository.getTimetableGroup()
}