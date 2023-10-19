package com.example.timetableapp.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.timetableapp.presentation.navigation.AppNavGraph
import com.example.timetableapp.presentation.navigation.Screen
import com.example.timetableapp.presentation.navigation.rememberNavigationState
import com.example.timetableapp.presentation.screens.home.HomeScreenStudent
import com.example.timetableapp.presentation.screens.home.HomeScreenTeacher
import com.example.timetableapp.presentation.screens.timetable.TimetableScreen

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun WelcomeScreen() {
    val navigationState = rememberNavigationState()
    AppNavGraph(
        navHostController = navigationState.navHostController,
        chooseStudentScreenContent = {
            ChooseStudentScreen(
                onApplyClickListener = {
                    navigationState.navigateTo(Screen.HomeScreenStudent.route)
                },
                onBackPressClickListener = {
                    navigationState.navHostController.popBackStack()
                })
        },
        chooseTeacherScreenContent = {
            ChooseTeacherScreen(
                onApplyClickListener = {
                    navigationState.navigateTo(Screen.HomeScreenTeacher.route)
                },
                onBackPressClickListener = {
                    navigationState.navHostController.popBackStack()
                })
        },
        welcomeScreenContent = {
            ChooseScreen(
                onStudentClickListener = { navigationState.navigateTo(Screen.ChooseStudentScreen.route) }) {
                navigationState.navigateTo(Screen.ChooseTeacherScreen.route)
            }
        },
        homeScreenTeacherContent = {
            HomeScreenTeacher(
                onPersonalTimetableClickListener = { navigationState.navigateTo(Screen.DateSelectionScreen.route) },
                onGroupTimetableClickListener = { navigationState.navigateTo(Screen.GroupAndDateSelectionScreen.route) })
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
                }
            )
        },
        groupSelectionContent = {
            DateSelectionScreen(showTimetableClickListener = {
                navigationState.navigateTo(Screen.TimetableScreen.route)
            })
        },
        timetableContent = {
            TimetableScreen(
                onBackPressClickListener = {
                    navigationState.navHostController.popBackStack()
                }
            )
        })

}

