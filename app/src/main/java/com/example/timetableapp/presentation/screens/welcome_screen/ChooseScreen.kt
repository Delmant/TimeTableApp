package com.example.timetableapp.presentation.screens.welcome_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timetableapp.presentation.components.AppIcon
import com.example.timetableapp.presentation.components.ButtonWithoutIcon
import com.example.timetableapp.presentation.components.GradientMediumText
import com.example.timetableapp.presentation.components.RegularText
import com.example.timetableapp.ui.theme.TimeTableAppTheme

@Composable
fun ChooseScreen(
    onStudentClickListener: () -> Unit,
    onTeacherClickListener: () -> Unit
) {
    TimeTableAppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,

            ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RegularText(text = "Узнай своё ")
                GradientMediumText(text = "расписание")
                GradientMediumText(text = "на каждый день")
                Spacer(modifier = Modifier.height(12.dp))
                ButtonWithoutIcon("\uD83E\uDDD1 Я студент") {
                    onStudentClickListener()
                }

                ButtonWithoutIcon("\uD83E\uDDD1 Я преподаватель") {
                    onTeacherClickListener()
                }
            }
        }
        AppIcon()
    }
}