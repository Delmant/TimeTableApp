package com.example.timetableapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.timetableapp.presentation.navigation.Screen
import com.example.timetableapp.presentation.screens.components.AppIcon
import com.example.timetableapp.presentation.screens.components.ButtonWithoutIcon
import com.example.timetableapp.presentation.screens.components.GradientSmallText
import com.example.timetableapp.presentation.screens.components.SpacerHeight20dp

@Composable
fun HomeScreenStudent(
    onTimetableByDateClickListener: () -> Unit,
    onTimetableTodayClickListener: () -> Unit
) {
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
            GradientSmallText(text = "\uD83C\uDF03Доброй ночи, Удрас Д.Н.")
            SpacerHeight20dp()
            ButtonWithoutIcon(text = "Расписание сегодня") {
                onTimetableTodayClickListener()
            }
            ButtonWithoutIcon(text = "Расписание по дате") {
                onTimetableByDateClickListener()
            }
        }
    }
    AppIcon()
}