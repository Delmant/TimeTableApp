package com.example.timetableapp.presentation.screens.timetable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.timetableapp.presentation.screens.shared_components.SpacerHeight20dp
import com.example.timetableapp.presentation.screens.shared_components.WhiteFont26SP
import com.example.timetableapp.presentation.screens.timetable.components.TimetableItemCard
import com.example.timetableapp.presentation.screens.timetable.components.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimetableScreen(
    onBackPressClickListener: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.TopCenter,

        ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTopAppBar(
                onBackPressClickListener = {
                    onBackPressClickListener()
                },
                topAppBarContent = {
                    WhiteFont26SP("ГЗТ-245")
                    WhiteFont26SP("16.06.1985")
                }
            )
            SpacerHeight20dp()
            val lazyListState = rememberLazyListState()

            LazyColumn(state = lazyListState) {
                items(5) {
                    TimetableItemCard()
                }
            }
        }
    }
}