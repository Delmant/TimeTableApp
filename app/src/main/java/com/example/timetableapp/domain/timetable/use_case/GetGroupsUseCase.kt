package com.example.timetableapp.domain.timetable.use_case

import com.example.timetableapp.domain.reaction.Reaction
import com.example.timetableapp.domain.timetable.model.Groups
import com.example.timetableapp.domain.timetable.repository.TimetableRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetGroupsUseCase @Inject constructor(private val timetableRepository: TimetableRepository) {
     operator fun invoke(): Flow<Reaction<Groups>> = timetableRepository.getGroups()
}