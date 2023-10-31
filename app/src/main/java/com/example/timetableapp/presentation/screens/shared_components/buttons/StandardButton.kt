package com.example.timetableapp.presentation.screens.shared_components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timetableapp.R
import com.example.timetableapp.ui.theme.MainBlue

@Composable
fun StandardButton(
    text: String,
    paddingValues: PaddingValues,
    buttonClickListener: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth().padding(paddingValues),
        onClick = { buttonClickListener() },
        colors = ButtonDefaults.buttonColors(MainBlue)
    ) {
        Box(
            modifier = Modifier.clip(CircleShape)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(6.dp),
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.montserrat_bold))
            )
        }
    }
}