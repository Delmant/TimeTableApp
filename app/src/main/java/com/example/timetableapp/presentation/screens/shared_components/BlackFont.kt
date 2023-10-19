package com.example.timetableapp.presentation.screens.shared_components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timetableapp.R

@Composable
fun BlackFont30SP(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(8.dp),
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.montserrat_black)),
        fontSize = 30.sp,
        color = MaterialTheme.colorScheme.secondary
    )
}