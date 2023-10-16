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

    object HomeScreenTeacher : Screen(
        route = ROUTE_HOME_SCREEN_STUDENT
    )

    object HomeScreenStudent : Screen(
        route = ROUTE_HOME_SCREEN_TEACHER
    )

    object GroupAndDateSelectionScreen: Screen(
        route = ROUTE_GROUP_AND_DATE_SELECTION_SCREEN
    )

    object DateSelectionScreen: Screen(
        route = ROUTE_DATE_SELECTION_SCREEN
    )

    companion object {
        private const val ROUTE_WELCOME_SCREEN = "route_welcome_screen"
        private const val ROUTE_CHOOSE_STUDENT_SCREEN = "route_choose_student_screen"
        private const val ROUTE_CHOOSE_TEACHER_SCREEN = "route_choose_teacher_screen"
        private const val ROUTE_HOME_SCREEN_STUDENT = "route_home_screen_student"
        private const val ROUTE_HOME_SCREEN_TEACHER = "route_home_screen_teacher"
        private const val ROUTE_GROUP_AND_DATE_SELECTION_SCREEN = "route_group_and_date_selection_screen"
        private const val ROUTE_DATE_SELECTION_SCREEN = "route_date_selection_screen"
    }
}