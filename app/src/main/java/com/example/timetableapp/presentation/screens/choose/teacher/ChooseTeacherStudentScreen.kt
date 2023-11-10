package com.example.timetableapp.presentation.screens.choose.teacher

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timetableapp.domain.timetable.model.Teachers
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.presentation.screens.shared_components.AppIcon
import com.example.timetableapp.presentation.screens.shared_components.ExposedDropDownMenu
import com.example.timetableapp.presentation.screens.shared_components.GradientMediumText
import com.example.timetableapp.presentation.screens.shared_components.ProgressIndicator
import com.example.timetableapp.presentation.screens.shared_components.RegularText
import com.example.timetableapp.presentation.screens.shared_components.buttons.GradientButton
import com.example.timetableapp.presentation.screens.shared_components.spacer.SpacerHeight20dp

@Composable
fun ChooseTeacherScreen(
    onApplyClickListener: () -> Unit,
    onBackPressClickListener: () -> Unit

) {

    val viewModel = hiltViewModel<ChooseTeacherViewModel>()
    viewModel.getTeachers()
    val viewModelState = viewModel.state.collectAsState().value

    val context = LocalContext.current

    when (viewModelState) {
        is ChooseTeacherScreenState.Initial -> {

        }

        is ChooseTeacherScreenState.IsLoading -> {
            ProgressIndicator()
        }

        is ChooseTeacherScreenState.Result -> {
            MainContent(
                context,
                viewModel,
                onApplyClickListener,
                onBackPressClickListener,
                viewModelState.teachers
            )
        }
    }

    AppIcon()
}

@Composable
private fun MainContent(
    context: Context,
    viewModel: ChooseTeacherViewModel,
    onApplyClickListener: () -> Unit,
    onBackPressClickListener: () -> Unit,
    teachers: Teachers
) {
    val chooseNameState = remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RegularText(text = "Отлично!")
            GradientMediumText(text = "Осталось только указать ваше имя")
            SpacerHeight20dp()
            ExposedDropDownMenu(
                paddingValues = PaddingValues(12.dp),
                teachers.teachers
            ) {
                Log.d("VOOT", "$it")
                chooseNameState.value = it
            }
            SpacerHeight20dp()
            GradientButton(text = "\uD83D\uDCBCНачать") {

                if (chooseNameState.value == "") {
                    Toast.makeText(context, "Выберите имя", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.setupTeacherProfile(UserProfile.Teacher(chooseNameState.value))
                    onApplyClickListener()
                }
            }

            GradientButton(text = "Назад") {
                onBackPressClickListener()
            }
        }
    }
}
