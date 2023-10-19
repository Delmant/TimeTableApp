package com.example.timetableapp.presentation.screens.timetable.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timetableapp.presentation.screens.shared_components.GradientSmallText
import com.example.timetableapp.presentation.screens.shared_components.SpacerWidth20dp
import com.example.timetableapp.presentation.screens.shared_components.WhiteFont12SP
import com.example.timetableapp.presentation.screens.shared_components.WhiteFont16SP

@Preview
@Composable
fun TimetableItemCard(

) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(
            topStart = 10.dp,
            topEnd = 10.dp,
            bottomStart = 10.dp,
            bottomEnd = 10.dp
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0174F3))
                .padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    GradientSmallText(text = "1")
                }
                SpacerWidth20dp()
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    WhiteFont16SP("Дискретная математика")
                    WhiteFont12SP(text = "Бебурах М.А.")
                    WhiteFont12SP(text = "Аудитория: 3-414")
                }
                Column(
                    verticalArrangement = Arrangement.Top
                ) {
                    WhiteFont16SP("1 П/Г")
                }
            }
        }
    }
}


