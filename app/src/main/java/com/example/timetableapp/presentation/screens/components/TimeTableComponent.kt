package com.example.timetableapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
fun GradientSmallText(text: String) {
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
fun ButtonWithoutIcon(text: String, buttonClickListener: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { buttonClickListener() },
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            colorResource(id = R.color.font_blue),
                            colorResource(id = R.color.purple)
                        )
                    )
                )
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
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
//        modifier = Modifier.fillMaxWidth(),
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

@Composable
fun SpacerHeight20dp() {
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun SpacerHeight10dp() {
    Spacer(modifier = Modifier.height(10.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropDownMenu() {

    var isExpanded by remember { mutableStateOf(false) }
    var item by remember { mutableStateOf("выбрать") }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = !isExpanded }) {
        androidx.compose.material3.TextField(
            value = item,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            modifier = Modifier.menuAnchor(),
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp,
                bottomStart = 10.dp,
                bottomEnd = 10.dp
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent, // Цвет индикатора в фокусе
                unfocusedIndicatorColor = Color.Transparent, // Цвет индикатора вне фокуса
                disabledIndicatorColor = Color.Transparent, // Цвет индикатора при выключенном состоянии
            )
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }) {
            DropdownMenuItem(text = { Text(text = "БП1-111") }, onClick = {
                item = "БП1-111"
                isExpanded = false
            })
            DropdownMenuItem(text = { Text(text = "БП2-222") }, onClick = {
                item = "БП2-222"
                isExpanded = false
            })
            DropdownMenuItem(text = { Text(text = "БП3-333") }, onClick = {
                item = "БП3-333"
                isExpanded = false
            })
        }
    }

}
