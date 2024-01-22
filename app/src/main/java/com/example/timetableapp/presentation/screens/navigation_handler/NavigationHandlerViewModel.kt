package com.example.timetableapp.presentation.screens.navigation_handler

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timetableapp.domain.reaction.Reaction
import com.example.timetableapp.domain.user_profile.use_case.GetUserProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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

                when (it) {
                    is Reaction.Error -> {

                    }

                    is Reaction.Success -> {
                        _state.value =
                            NavigationHandlerState.Result(userProfile = it.data)
                    }
                }
            }
        }
    }

}