package com.example.timetableapp.presentation.navigation

sealed class Screen(val route: String) {

    object WelcomeScreen : Screen(
        route = ROUTE_WELCOME_SCREEN
    )

    object ChooseStudentScreen : Screen(
        route = ROUTE_CHOOSE_STUDENT_SCREEN
    )

    object ChooseTeacherScreen : Screen(
        route = ROUTE_CHOOSE_TEACHER_SCREEN
    )

    object HomeScreen : Screen(
        route = ROUTE_HOME_SCREEN
    )

    companion object {
        private const val ROUTE_WELCOME_SCREEN = "route_welcome_screen"
        private const val ROUTE_CHOOSE_STUDENT_SCREEN = "route_choose_student_screen"
        private const val ROUTE_CHOOSE_TEACHER_SCREEN = "route_choose_teacher_screen"
        private const val ROUTE_HOME_SCREEN = "route_home_screen"
    }
}