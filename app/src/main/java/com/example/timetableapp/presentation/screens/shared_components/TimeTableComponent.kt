package com.example.timetableapp.presentation.screens.shared_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timetableapp.R

@Composable
fun RegularLineText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun RegularText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun RegularSmallText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall,
        textAlign = TextAlign.Center
    )
}

@Composable
fun GradientMediumText(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.lack_regular)),
        fontSize = 32.sp,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    colorResource(id = R.color.font_blue),
                    colorResource(id = R.color.purple)
                )
            )
        )
    )
}

@Composable
fun GradientAlmostMediumText(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.lack_regular)),
        fontSize = 24.sp,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    colorResource(id = R.color.font_blue),
                    colorResource(id = R.color.purple)
                )
            )
        )
    )
}

@Composable
fun GradientSmallText(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(R.font.lack_regular)),
        fontSize = 16.sp,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    colorResource(id = R.color.font_blue),
                    colorResource(id = R.color.purple)
                )
            )
        )
    )
}



@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TextField(label: String, onDoneClickListener: () -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 12.sp
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                onDoneClickListener()
            }
        ),
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.lack_regular)),
            fontSize = 16.sp,
            letterSpacing = 0.5.sp,
            color = Color.White
        )
    )
}

@Composable
fun AppIcon() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)
        }
    }
}


