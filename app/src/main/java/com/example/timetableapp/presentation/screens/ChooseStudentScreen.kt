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
import com.example.timetableapp.presentation.screens.shared_components.AppIcon
import com.example.timetableapp.presentation.screens.shared_components.ButtonWithoutIcon
import com.example.timetableapp.presentation.screens.shared_components.ExposedDropDownMenu
import com.example.timetableapp.presentation.screens.shared_components.GradientMediumText
import com.example.timetableapp.presentation.screens.shared_components.RegularText
import com.example.timetableapp.presentation.screens.shared_components.SpacerHeight20dp

@Composable
fun ChooseStudentScreen(
    onApplyClickListener: () -> Unit,
    onBackPressClickListener: () -> Unit,
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
            GradientMediumText(text = "Осталось только указать твою группу")
            SpacerHeight20dp()
            ExposedDropDownMenu()
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