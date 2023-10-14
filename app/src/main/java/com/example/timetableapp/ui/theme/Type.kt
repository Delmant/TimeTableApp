package com.example.timetableapp.ui.theme

import androidx.annotation.ColorRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.timetableapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium   = TextStyle(
        fontFamily = FontFamily(Font(R.font.lack_regular)),
        fontSize = 32.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    ),
    titleMedium   = TextStyle(
        fontFamily = FontFamily(Font(R.font.lack_regular)),
        fontSize = 32.sp,
        letterSpacing = 0.5.sp,
        color = Color(0xFF0174F3)
    )

)