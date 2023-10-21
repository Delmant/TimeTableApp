package com.example.timetableapp.presentation.screens.timetable.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.timetableapp.presentation.screens.shared_components.spacer.SpacerHeight10dp

@Composable
fun SeparateLine() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color(0xFF0174F3))
    ) {

    }
    SpacerHeight10dp()
}