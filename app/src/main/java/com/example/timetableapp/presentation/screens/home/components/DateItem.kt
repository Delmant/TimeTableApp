package com.example.timetableapp.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timetableapp.presentation.screens.shared_components.spacer.SpacerHeight10dp
import com.example.timetableapp.presentation.screens.shared_components.spacer.SpacerWidth20dp
import com.example.timetableapp.presentation.screens.shared_components.text.WhiteFont16SP
import com.example.timetableapp.ui.theme.MainBlue

@Composable
fun DateItem() {
    Row {
        Card(
            shape = RoundedCornerShape(25.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(MainBlue)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WhiteFont16SP(text = "ПНД")
                    SpacerHeight10dp()
                    WhiteFont16SP(text = "20")
                }
            }
        }
        SpacerWidth20dp()
    }
}