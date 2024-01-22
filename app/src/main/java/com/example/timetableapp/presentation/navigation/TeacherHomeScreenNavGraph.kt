package com.example.timetableapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation


fun NavGraphBuilder.teacherHomeScreenNavGraph(
    homeScreenTeacherContent: @Composable () -> Unit,
    groupAndDateSelectionContent: @Composable () -> Unit,
    groupSelectionContent: @Composable () -> Unit,
    timetableContent: @Composable () -> Unit
) {
    navigation(
        startDestination = Screen.HomeScreenTeacher.route,
        route = "teacher_home_screen_r5f"
    ) {
        composable(Screen.HomeScreenTeacher.route) {
            homeScreenTeacherContent()
        }

        composable(Screen.GroupAndDateSelectionScreen.route) {
            groupAndDateSelectionContent()
        }

        composable(Screen.DateSelectionScreen.route) {
            groupSelectionContent()
        }

        composable(Screen.TimetableScreen.route) {
            timetableContent()
        }
    }

}