package com.example.timetableapp.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.timetableapp.presentation.screens.home.components.BackgroundCard
import com.example.timetableapp.presentation.screens.home.components.DateLazyRow
import com.example.timetableapp.presentation.screens.shared_components.AppIcon
import com.example.timetableapp.presentation.screens.shared_components.buttons.StandardButton
import com.example.timetableapp.presentation.screens.shared_components.spacer.SpacerHeight20dp
import com.example.timetableapp.presentation.screens.shared_components.text.BlackFont30SP
import com.example.timetableapp.presentation.screens.shared_components.text.WhiteFont26SP
import com.example.timetableapp.presentation.screens.shared_components.text.WhiteFontTitle
import com.example.timetableapp.ui.theme.MainBlue

@Composable
fun HomeScreenTeacher(
    onPersonalTimetableClickListener: () -> Unit,
    onGroupTimetableClickListener: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBlue),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier.weight(1f)
            ) {
                HeadContent()
            }
            Box(
                modifier = Modifier.weight(4f)
            ) {
                MainContent(onPersonalTimetableClickListener, onGroupTimetableClickListener)
            }
        }
    }
}

@Composable
private fun HeadContent() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            Column(
                Modifier.padding(start = 30.dp)
            ) {
                WhiteFontTitle(text = "\uD83C\uDF03 Доброй ночи,")
                WhiteFontTitle(text = "Бебурах М.А.")
            }
        }
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 50.dp
                        )
                    )
                    .background(Color.White), contentAlignment = Alignment.TopEnd
            ) {
                AppIcon()
            }
        }
    }
}

@Composable
private fun MainContent(
    onPersonalTimetableClickListener: () -> Unit,
    onGroupTimetableClickListener: () -> Unit
) {
    BackgroundCard {
        SpacerHeight20dp()
        SpacerHeight20dp()
        BlackFont30SP(
            "Cентябрь 20",
            paddingValues = PaddingValues(
                start = 12.dp,
                end = 12.dp
            )
        )
        DateLazyRow()
        SpacerHeight20dp()



        SpacerHeight20dp()
        BlackFont30SP(
            "Выбор расписания",
            paddingValues = PaddingValues(
                start = 12.dp,
                end = 12.dp
            )
        )
        StandardButton(
            text = "Своё расписание",
            paddingValues = PaddingValues(12.dp)
        ) {
            onPersonalTimetableClickListener()
        }
        StandardButton(
            text = "Расписание группы",
            paddingValues = PaddingValues(12.dp)
        ) {
            onGroupTimetableClickListener()
        }
    }
}