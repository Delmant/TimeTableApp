package com.example.timetableapp.presentation.screens.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DateLazyRow() {
    val lazyListState = rememberLazyListState()
    LazyRow(
        modifier = Modifier.padding(8.dp),
        state = lazyListState
    ) {
        items(20) {
            DateItem()
        }
    }
}