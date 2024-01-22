package com.example.timetableapp.presentation.screens.choose.teacher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetableapp.domain.reaction.Reaction
import com.example.timetableapp.domain.timetable.use_case.GetTeachersUseCase
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.use_case.SetupTeacherProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChooseTeacherViewModel @Inject constructor(
    private val setupTeacherProfileUseCase: SetupTeacherProfileUseCase,
    private val getTeachersUseCase: GetTeachersUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow(ChooseTeacherScreenState.Initial as ChooseTeacherScreenState)
    val state = _state.asStateFlow()
    fun setupTeacherProfile(userProfile: UserProfile.Teacher) {
        viewModelScope.launch(Dispatchers.IO) {
            setupTeacherProfileUseCase.invoke(userProfile)
        }
    }

    fun getTeachers() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = ChooseTeacherScreenState.IsLoading
            getTeachersUseCase.invoke().collect {
               when(it) {
                   is Reaction.Error -> {
                       _state.value = ChooseTeacherScreenState.Error(
                           exception = it.exception
                       )
                   }
                   is Reaction.Success -> {
                       _state.value = ChooseTeacherScreenState.Result(
                           teachers = it.data
                       )
                   }
               }
            }
        }
    }
}
