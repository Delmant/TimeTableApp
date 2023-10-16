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
import com.example.timetableapp.presentation.screens.components.AppIcon
import com.example.timetableapp.presentation.screens.components.ButtonWithoutIcon
import com.example.timetableapp.presentation.screens.components.GradientMediumText
import com.example.timetableapp.presentation.screens.components.RegularText
import com.example.timetableapp.presentation.screens.components.SpacerHeight20dp
import com.example.timetableapp.presentation.screens.components.TextField

@Composable
fun ChooseTeacherScreen(
    onApplyClickListener: () -> Unit,
    onBackPressClickListener: () -> Unit
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
            RegularText(text = "Отлично!")
            GradientMediumText(text = "Осталось только указать ваше имя")
            SpacerHeight20dp()
            TextField("Имя") {

            }
            SpacerHeight20dp()
            ButtonWithoutIcon(text = "\uD83D\uDCBCНачать") {
                onApplyClickListener()
            }

            ButtonWithoutIcon(text = "Назад") {
                onBackPressClickListener()
            }
        }
    }
    AppIcon()
}
