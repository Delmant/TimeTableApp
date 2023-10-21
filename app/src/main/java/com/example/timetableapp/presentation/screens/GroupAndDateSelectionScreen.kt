package com.example.timetableapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timetableapp.presentation.screens.shared_components.ExposedDropDownMenu
import com.example.timetableapp.presentation.screens.shared_components.buttons.GradientButton
import com.example.timetableapp.presentation.screens.shared_components.buttons.StandardButton
import com.example.timetableapp.presentation.screens.shared_components.spacer.SpacerHeight10dp
import com.example.timetableapp.presentation.screens.shared_components.spacer.SpacerHeight20dp
import com.example.timetableapp.presentation.screens.shared_components.text.BlackFont30SP
import com.example.timetableapp.presentation.screens.shared_components.text.WhiteFont26SP
import com.example.timetableapp.presentation.screens.timetable.components.CustomTopAppBar

@Composable
fun GroupAndDateSelectionScreen(
    showTimetableClickListener: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            CustomTopAppBar(onBackPressClickListener = { /*TODO*/ }) {
                WhiteFont26SP(text = "Выбор расписания")
            }
        }
        Box(
            modifier = Modifier.weight(1f),

            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

//                SpacerHeight20dp()
//                SpacerHeight20dp()

                BlackFont30SP(
                    text = "Выберите группу",
                    paddingValues = PaddingValues(
                        start = 12.dp,
                        end = 12.dp
                    )
                )
                SpacerHeight10dp()
                ExposedDropDownMenu(
                    paddingValues = PaddingValues(
                        start = 12.dp,
                        end = 12.dp,
                        bottom = 12.dp
                    )
                )
                SpacerHeight20dp()
                BlackFont30SP(
                    text = "Выберите дату", paddingValues = PaddingValues(
                        start = 12.dp,
                        end = 12.dp
                    )
                )
                SpacerHeight10dp()
                ExposedDropDownMenu(
                    paddingValues = PaddingValues(
                        start = 12.dp,
                        end = 12.dp,
                        bottom = 12.dp
                    )
                )
                SpacerHeight20dp()

            }
        }
        StandardButton(
            text = "\uD83D\uDD0E Искать",
            paddingValues = PaddingValues(12.dp)
        ) {
            showTimetableClickListener()
        }
    }
}