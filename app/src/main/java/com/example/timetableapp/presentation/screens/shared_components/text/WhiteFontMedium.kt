package com.example.timetableapp.presentation.screens.shared_components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.timetableapp.R

@Composable
fun WhiteFontMedium(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.lack_regular)),
        fontSize = 32.sp,
        color = Color.White
    )
}

@Composable
fun WhiteFont16SP(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
        fontSize = 16.sp,
        color = Color.White
    )
}

@Composable
fun WhiteFont12SP(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
        fontSize = 12.sp,
        color = Color.White
    )
}

@Composable
fun WhiteFont26SP(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
        fontSize = 26.sp,
        color = Color.White
    )
}

@Composable
fun WhiteFontTitle(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
        fontSize = 26.sp,
        color = Color.White
    )
}