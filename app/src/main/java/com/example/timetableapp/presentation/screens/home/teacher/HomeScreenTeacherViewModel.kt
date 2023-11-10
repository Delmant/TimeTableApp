package com.example.timetableapp.presentation.screens.home.teacher

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.use_case.GetUserProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenTeacherViewModel @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenTeacherState.Initial as HomeScreenTeacherState)
    val state = _state.asStateFlow()

    fun getUserProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = HomeScreenTeacherState.IsLoading
            getUserProfileUseCase.invoke().collect {
                _state.value = HomeScreenTeacherState.Result(
                    teacherProfile = it as UserProfile.Teacher
                )
            }
        }
    }
}