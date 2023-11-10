package com.example.timetableapp.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timetableapp.presentation.screens.home.components.BackgroundCard
import com.example.timetableapp.presentation.screens.shared_components.AppIcon
import com.example.timetableapp.presentation.screens.shared_components.GradientSmallText
import com.example.timetableapp.presentation.screens.shared_components.buttons.GradientButton
import com.example.timetableapp.presentation.screens.shared_components.buttons.StandardButton
import com.example.timetableapp.presentation.screens.shared_components.spacer.SpacerHeight20dp
import com.example.timetableapp.ui.theme.MainBlue

@Composable
fun HomeScreenStudent(
    onTimetableByDateClickListener: () -> Unit,
    onTimetableTodayClickListener: () -> Unit
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

            }
            Box(
                modifier = Modifier.weight(4f)
            ) {
                MainContent(onTimetableTodayClickListener, onTimetableByDateClickListener)
            }
        }
    }
}

@Composable
private fun MainContent(
    onTimetableTodayClickListener: () -> Unit,
    onTimetableByDateClickListener: () -> Unit
) {
    BackgroundCard() {
        SpacerHeight20dp()
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
    }
}