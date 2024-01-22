package com.example.timetableapp.presentation.screens.home.student

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.presentation.screens.home.components.BackgroundCard
import com.example.timetableapp.presentation.screens.home.components.DateLazyRow
import com.example.timetableapp.presentation.screens.shared_components.AppIcon
import com.example.timetableapp.presentation.screens.shared_components.Constants
import com.example.timetableapp.presentation.screens.shared_components.ProgressIndicator
import com.example.timetableapp.presentation.screens.shared_components.buttons.StandardButton
import com.example.timetableapp.presentation.screens.shared_components.spacer.SpacerHeight20dp
import com.example.timetableapp.presentation.screens.shared_components.text.BlackFont30SP
import com.example.timetableapp.presentation.screens.shared_components.text.WhiteFontTitle
import com.example.timetableapp.ui.theme.MainBlue

@Composable
fun HomeScreenStudent(
    onTimetableByDateClickListener: () -> Unit,
    onTimetableTodayClickListener: () -> Unit,
    onDateItemClickListener: () -> Unit,
    navigateToChooseScreen: () -> Unit
) {
    val viewModel = hiltViewModel<HomeScreenStudentViewModel>()
    viewModel.getUserProfile()
    val viewModelState = viewModel.state.collectAsState().value

    when (viewModelState) {
        is HomeScreenStudentState.Initial -> {

        }

        is HomeScreenStudentState.IsLoading -> {
            ProgressIndicator()
        }

        is HomeScreenStudentState.ProfileResetAndNavigateToHome -> {
            navigateToChooseScreen()
        }

        is HomeScreenStudentState.Error -> {

        }

        is HomeScreenStudentState.Result -> {
            Log.d("USER_PROFILE", viewModelState.studentProfile.studentGroup)
            MainContent(
                onTimetableTodayClickListener,
                onTimetableByDateClickListener,
                navigateToChooseScreen,
                viewModel,
                viewModelState.studentProfile,
                onDateItemClickListener
            )
        }
    }

}

@Composable
private fun MainContent(
    onTimetableTodayClickListener: () -> Unit,
    onTimetableByDateClickListener: () -> Unit,
    navigateToChooseScreen: () -> Unit,
    viewModel: HomeScreenStudentViewModel,
    studentProfile: UserProfile.Student,
    onDateItemClickListener: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBlue),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                HeadContent(studentProfile)
            }
            Box(
                modifier = Modifier.weight(4f)
            ) {
                BodyContent(
                    onTimetableTodayClickListener,
                    onTimetableByDateClickListener,
                    viewModel,
                    navigateToChooseScreen,
                    onDateItemClickListener
                )
            }
        }
    }
}

@Composable
private fun HeadContent(
    studentProfile: UserProfile.Student
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            Column(
                Modifier.padding(start = Constants.BASE_PADDING_30_DP)
            ) {
                //🌃
                WhiteFontTitle(text = "Доброй ночи,")
                WhiteFontTitle(text = studentProfile.studentGroup)
            }
        }
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = Constants.BASE_PADDING_50_DP
                        )
                    )
                    .background(Color.White), contentAlignment = Alignment.TopEnd
            ) {
                AppIcon()
            }
        }
    }
}

@Composable
private fun BodyContent(
    onTimetableTodayClickListener: () -> Unit,
    onTimetableByDateClickListener: () -> Unit,
    viewModel: HomeScreenStudentViewModel,
    dateItemOnClickListener: () -> Unit,
    navigateToChooseScreen: () -> Unit
) {
    BackgroundCard() {
        SpacerHeight20dp()
        SpacerHeight20dp()
        BlackFont30SP(
            "Cентябрь 20",
            paddingValues = PaddingValues(
                start = Constants.BASE_PADDING_12_DP,
                end = Constants.BASE_PADDING_12_DP
            )
        )
        DateLazyRow() {
            dateItemOnClickListener()
        }
        SpacerHeight20dp()



        SpacerHeight20dp()
        BlackFont30SP(
            "Выбор расписания",
            paddingValues = PaddingValues(
                start = Constants.BASE_PADDING_12_DP,
                end = Constants.BASE_PADDING_12_DP
            )
        )
        StandardButton(
            text = "Расписание сегодня",
            paddingValues = PaddingValues(12.dp)
        ) {
            onTimetableTodayClickListener()
        }
        StandardButton(
            text = "Расписание по дате",
            paddingValues = PaddingValues(12.dp)
        ) {
            onTimetableByDateClickListener()
        }

        SpacerHeight20dp()
        BlackFont30SP(
            "Настройки",
            paddingValues = PaddingValues(
                start = Constants.BASE_PADDING_12_DP,
                end = Constants.BASE_PADDING_12_DP
            )
        )
        StandardButton(
            text = "Сброс профиля",
            paddingValues = PaddingValues(Constants.BASE_PADDING_12_DP)
        ) {
            viewModel.resetUserProfile()
            navigateToChooseScreen()
        }
    }
}