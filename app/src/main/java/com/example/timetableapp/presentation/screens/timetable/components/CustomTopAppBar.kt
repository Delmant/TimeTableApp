package com.example.timetableapp.presentation.screens.timetable.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.timetableapp.R
import com.example.timetableapp.presentation.screens.shared_components.SpacerHeight10dp
import com.example.timetableapp.presentation.screens.shared_components.WhiteFont26SP
import com.example.timetableapp.ui.theme.MainBlue

@Composable
fun CustomTopAppBar(
    onBackPressClickListener: () -> Unit,
    topAppBarContent :@Composable() (ColumnScope.() -> Unit)
) {
    Card(
        modifier = Modifier,
        shape = RoundedCornerShape(
            bottomStart = 50.dp,
            bottomEnd = 50.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MainBlue)
                .padding(24.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.clickable {
                    onBackPressClickListener()
                },
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = null
            )
            SpacerHeight10dp()
            topAppBarContent()
        }
    }
}