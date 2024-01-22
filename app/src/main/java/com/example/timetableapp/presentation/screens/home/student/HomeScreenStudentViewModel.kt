package com.example.timetableapp.presentation.screens.home.student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetableapp.domain.reaction.Reaction
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.use_case.GetUserProfileUseCase
import com.example.timetableapp.domain.user_profile.use_case.ResetUserProfileUseCase
import com.example.timetableapp.presentation.screens.home.teacher.HomeScreenTeacherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenStudentViewModel @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val resetUserProfileUseCase: ResetUserProfileUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenStudentState.Initial as HomeScreenStudentState)
    val state = _state.asStateFlow()

    fun getUserProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = HomeScreenStudentState.IsLoading
            getUserProfileUseCase.invoke().collect {
                when (it) {
                    is Reaction.Error -> {
                        _state.value = HomeScreenStudentState.Error(
                            exception = it.exception
                        )
                    }

                    is Reaction.Success -> {
                        when (val userProfile = it.data as? UserProfile.Student) {
                            is UserProfile.Student -> _state.value =
                                HomeScreenStudentState.Result(studentProfile = userProfile)

                            else -> _state.value =
                                HomeScreenStudentState.ProfileResetAndNavigateToHome
                        }
                    }

                }
            }
        }
    }

    fun resetUserProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            resetUserProfileUseCase.invoke()
            _state.value = HomeScreenStudentState.ProfileResetAndNavigateToHome
        }
    }
}