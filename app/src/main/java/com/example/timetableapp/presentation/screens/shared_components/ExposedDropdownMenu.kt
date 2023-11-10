package com.example.timetableapp.presentation.screens.shared_components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timetableapp.R
import com.example.timetableapp.ui.theme.MainBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropDownMenu(
    paddingValues: PaddingValues,
    listItems: List<String>,
    onItemSelected: (String) -> Unit
) {

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
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                fontSize = 20.sp,
                letterSpacing = 0.5.sp,
                color = Color(0xFFFFFFFF)
            ),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(paddingValues),
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
                textColor = Color.White,
                containerColor = MainBlue
            )
        )

        ExposedDropdownMenu(
            modifier = Modifier.padding(paddingValues),
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }) {
            listItems.forEach {
                DropdownMenuItem(text = { Text(text = it) }, onClick = {
                    item = it
                    isExpanded = false
                    onItemSelected(it)
                })
            }
        }
    }

}
