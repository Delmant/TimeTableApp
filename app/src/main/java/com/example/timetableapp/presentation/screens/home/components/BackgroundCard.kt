package com.example.timetableapp.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BackgroundCard(
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Card(
        shape = RoundedCornerShape(
            topStart = 30.dp,
            topEnd = 30.dp
        )
    ) {
        Box(
            modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxSize()
        ) {
            Column(

            ){
                content()
            }
        }
    }
}