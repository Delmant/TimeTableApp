package com.example.timetableapp.presentation.screens.choose.student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetableapp.domain.reaction.Reaction
import com.example.timetableapp.domain.timetable.model.Groups
import com.example.timetableapp.domain.timetable.use_case.GetGroupsUseCase
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.use_case.SetupStudentProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

    @HiltViewModel
    class ChooseStudentViewModel @Inject constructor(
        private val setupStudentProfileUseCase: SetupStudentProfileUseCase,
        private val getGroupsUseCase: GetGroupsUseCase
    ) : ViewModel() {

        private val _state =
            MutableStateFlow(ChooseStudentScreenState.Initial as ChooseStudentScreenState)
        val state = _state.asStateFlow()
        fun setupStudentProfile(userProfile: UserProfile.Student) {
            viewModelScope.launch(Dispatchers.IO) {
                setupStudentProfileUseCase.invoke(userProfile)
            }
        }

        fun getGroups() {
            viewModelScope.launch(Dispatchers.IO) {
                _state.value = ChooseStudentScreenState.IsLoading
                getGroupsUseCase.invoke().collect {
                    when(it) {
                        is Reaction.Error -> {
                            _state.value = ChooseStudentScreenState.Error(
                                exception = it.exception
                            )
                        }
                        is Reaction.Success -> {
                            _state.value = ChooseStudentScreenState.Result(
                                groups = it.data
                            )
                        }
                    }
                }
            }
        }
    }