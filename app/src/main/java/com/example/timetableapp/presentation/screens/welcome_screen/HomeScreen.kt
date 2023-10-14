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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timetableapp.presentation.components.AppIcon
import com.example.timetableapp.presentation.components.ButtonWithoutIcon
import com.example.timetableapp.presentation.components.GradientMediumText
import com.example.timetableapp.presentation.components.GradientSmallText
import com.example.timetableapp.presentation.components.RegularText
import com.example.timetableapp.presentation.components.TextField

@Preview
@Composable
fun HomeScreen( ) {
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
        }
    }
    AppIcon()
}