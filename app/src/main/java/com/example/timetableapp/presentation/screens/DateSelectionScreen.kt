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
import com.example.timetableapp.presentation.screens.components.ExposedDropDownMenu
import com.example.timetableapp.presentation.screens.components.GradientSmallText
import com.example.timetableapp.presentation.screens.components.SpacerHeight10dp
import com.example.timetableapp.presentation.screens.components.SpacerHeight20dp

@Composable
fun DateSelectionScreen() {
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
            GradientSmallText(text = "Выберите дату")
            SpacerHeight10dp()
            ExposedDropDownMenu()
            SpacerHeight20dp()
            SpacerHeight20dp()
            ButtonWithoutIcon(text = "\uD83D\uDD0E Искать") {

            }
        }
    }
    AppIcon()
}