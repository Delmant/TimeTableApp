package com.example.timetableapp.domain.timetable.use_case

import com.example.timetableapp.domain.timetable.repository.TimetableRepository
import javax.inject.Inject

class GetGroupsUseCase @Inject constructor(private val timetableRepository: TimetableRepository) {
     operator fun invoke() = timetableRepository.getGroups()
}