package com.example.timetableapp.presentation.screens.navigation_handler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.use_case.GetUserProfileUseCase
import com.example.timetableapp.domain.user_profile.use_case.SetupStudentProfileUseCase
import com.example.timetableapp.domain.user_profile.use_case.SetupTeacherProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavigationHandlerViewModel @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NavigationHandlerState.Initial as NavigationHandlerState)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = NavigationHandlerState.IsLoading
            getUserProfileUseCase.invoke().collect {
                _state.value =
                    NavigationHandlerState.Result(userProfile = it)
            }
        }
    }

}