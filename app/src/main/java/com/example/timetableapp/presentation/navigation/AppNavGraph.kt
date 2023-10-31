package com.example.timetableapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    welcomeScreenContent: @Composable () -> Unit,
    chooseStudentScreenContent: @Composable () -> Unit,
    chooseTeacherScreenContent: @Composable () -> Unit,
    homeScreenTeacherContent: @Composable () -> Unit,
    homeScreenStudentContent: @Composable () -> Unit,
    groupAndDateSelectionContent: @Composable () -> Unit,
    groupSelectionContent: @Composable () -> Unit,
    timetableContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.WelcomeScreen.route,
        builder = {

            composable(Screen.WelcomeScreen.route) {
                welcomeScreenContent()
            }

            composable(Screen.ChooseStudentScreen.route) {
                chooseStudentScreenContent()
            }

            composable(Screen.ChooseTeacherScreen.route) {
                chooseTeacherScreenContent()
            }

            composable(Screen.HomeScreenStudent.route) {
                homeScreenStudentContent()
            }

            teacherHomeScreenNavGraph(
                homeScreenTeacherContent = homeScreenTeacherContent,
                groupSelectionContent = groupSelectionContent,
                groupAndDateSelectionContent = groupAndDateSelectionContent,
                timetableContent = timetableContent
            )
        })
}