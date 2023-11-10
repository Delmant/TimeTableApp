package com.example.timetableapp.presentation.screens.navigation_handler

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.presentation.navigation.AppNavGraph
import com.example.timetableapp.presentation.navigation.Screen
import com.example.timetableapp.presentation.navigation.rememberNavigationState
import com.example.timetableapp.presentation.screens.choose.ChooseScreen
import com.example.timetableapp.presentation.screens.choose.student.ChooseStudentScreen
import com.example.timetableapp.presentation.screens.choose.teacher.ChooseTeacherScreen
import com.example.timetableapp.presentation.screens.DateSelectionScreen
import com.example.timetableapp.presentation.screens.GroupAndDateSelectionScreen
import com.example.timetableapp.presentation.screens.home.HomeScreenStudent
import com.example.timetableapp.presentation.screens.home.teacher.HomeScreenTeacher
import com.example.timetableapp.presentation.screens.shared_components.ProgressIndicator
import com.example.timetableapp.presentation.screens.timetable.TimetableScreen

@Composable
fun NavigationHandler() {
    val viewModel = hiltViewModel<NavigationHandlerViewModel>()

    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        hostScreenContent = {

            when (viewModel.state.collectAsState().value) {
                is NavigationHandlerState.Initial -> {

                }

                is NavigationHandlerState.IsLoading -> {
                    ProgressIndicator()
                }

                is NavigationHandlerState.Result -> {
                    val result =
                        (viewModel.state.collectAsState().value
                                as NavigationHandlerState.Result
                                ).userProfile

                    when (result) {

                        is UserProfile.NotRegistered -> {
                            ChooseScreen(
                                onStudentClickListener = {
                                    navigationState.navigateTo(Screen.ChooseStudentScreen.route)
                                }) {
                                navigationState.navigateTo(Screen.ChooseTeacherScreen.route)
                            }
                        }

                        is UserProfile.Teacher -> {
                            navigationState.navigateToHome(Screen.HomeScreenTeacher.route)
                        }

                        is UserProfile.Student -> {
                            navigationState.navigateToHome(Screen.HomeScreenStudent.route)
                        }

                    }
                }
            }


        },
        chooseStudentScreenContent = {
            ChooseStudentScreen(
                onApplyClickListener = {
                    navigationState.navigateToHome(Screen.HomeScreenStudent.route)
                },
                onBackPressClickListener = {
                    navigationState.navHostController.popBackStack()
                })
        },
        chooseTeacherScreenContent = {
            ChooseTeacherScreen(
                onApplyClickListener = {
                    navigationState.navigateToHome(Screen.HomeScreenTeacher.route)
                },
                onBackPressClickListener = {
                    navigationState.navHostController.popBackStack()
                })
        },
        homeScreenTeacherContent = {
            HomeScreenTeacher(
                onPersonalTimetableClickListener = { navigationState.navigateTo(Screen.DateSelectionScreen.route) },
                onGroupTimetableClickListener = { navigationState.navigateTo(Screen.GroupAndDateSelectionScreen.route) },
                dateItemOnClickListener = { navigationState.navigateTo(Screen.TimetableScreen.route) })
        },
        homeScreenStudentContent = {
            HomeScreenStudent(
                onTimetableByDateClickListener = {},
                onTimetableTodayClickListener = {}
            )
        },
        groupAndDateSelectionContent = {
            GroupAndDateSelectionScreen(
                showTimetableClickListener = {
                    navigationState.navigateTo(Screen.TimetableScreen.route)
                },
                onBackPressClickListener = {
                    navigationState.navHostController.popBackStack()
                }
            )
        },
        groupSelectionContent = {
            DateSelectionScreen(
                showTimetableClickListener = {
                    navigationState.navigateTo(Screen.TimetableScreen.route)
                },
                onBackPressClickListener = {
                    navigationState.navHostController.popBackStack()
                }
            )
        },
        timetableContent = {
            TimetableScreen(
                onBackPressClickListener = {
                    navigationState.navHostController.popBackStack()
                }
            )
        })

}


