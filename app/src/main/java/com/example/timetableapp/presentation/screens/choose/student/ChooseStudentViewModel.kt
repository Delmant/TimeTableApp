package com.example.timetableapp.presentation.screens.choose.student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetableapp.domain.timetable.use_case.GetGroupsUseCase
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.use_case.SetupStudentProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ChooseStudentViewModel @Inject constructor(
    private val setupStudentProfileUseCase: SetupStudentProfileUseCase,
    private val getGroupsUseCase: GetGroupsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ChooseStudentScreenState.Initial as ChooseStudentScreenState)
    val state = _state.asStateFlow()
    fun setupStudentProfile(userProfile: UserProfile.Student) {
        viewModelScope.launch(Dispatchers.IO) {
            setupStudentProfileUseCase.invoke(userProfile)
        }
    }

    fun getGroups()  {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = ChooseStudentScreenState.IsLoading
            getGroupsUseCase.invoke().collect {
                _state.value = ChooseStudentScreenState.Result(
                    groups = it
                )
            }
        }
    }
}