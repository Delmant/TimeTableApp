package com.example.timetableapp.presentation.screens.home.teacher

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetableapp.domain.reaction.Reaction
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.domain.user_profile.use_case.GetUserProfileUseCase
import com.example.timetableapp.domain.user_profile.use_case.ResetUserProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenTeacherViewModel @Inject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    private val resetUserProfileUseCase: ResetUserProfileUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenTeacherState.Initial as HomeScreenTeacherState)
    val state = _state.asStateFlow()

    fun getUserProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = HomeScreenTeacherState.IsLoading
            getUserProfileUseCase.invoke().collect {
                when (it) {
                    is Reaction.Error -> {
                        _state.value = HomeScreenTeacherState.Error(
                            exception = it.exception
                        )
                    }

                    is Reaction.Success -> {
                        when (val userProfile = it.data as? UserProfile.Teacher) {
                            is UserProfile.Teacher -> _state.value =
                                HomeScreenTeacherState.Result(teacherProfile = userProfile)

                            else -> _state.value =
                                HomeScreenTeacherState.ProfileResetAndNavigateToHome
                        }
                    }

                }
            }
        }
    }

    fun resetUserProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            resetUserProfileUseCase.invoke()
            _state.value = HomeScreenTeacherState.ProfileResetAndNavigateToHome
        }
    }

}