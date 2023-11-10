package com.example.timetableapp.presentation.screens.choose.student

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timetableapp.domain.timetable.model.Groups
import com.example.timetableapp.domain.user_profile.model.UserProfile
import com.example.timetableapp.presentation.screens.shared_components.AppIcon
import com.example.timetableapp.presentation.screens.shared_components.ExposedDropDownMenu
import com.example.timetableapp.presentation.screens.shared_components.GradientMediumText
import com.example.timetableapp.presentation.screens.shared_components.ProgressIndicator
import com.example.timetableapp.presentation.screens.shared_components.RegularText
import com.example.timetableapp.presentation.screens.shared_components.buttons.GradientButton
import com.example.timetableapp.presentation.screens.shared_components.spacer.SpacerHeight20dp

@Composable
fun ChooseStudentScreen(
    onApplyClickListener: () -> Unit,
    onBackPressClickListener: () -> Unit,
) {
    val viewModel = hiltViewModel<ChooseStudentViewModel>()
    val viewModelState = viewModel.state.collectAsState().value
    viewModel.getGroups()

    val context = LocalContext.current
    val chooseNameState = remember {
        mutableStateOf("")
    }
    when (viewModelState) {
        is ChooseStudentScreenState.Initial -> {
            LoadingContent()
        }

        is ChooseStudentScreenState.IsLoading -> {
            LoadingContent()
        }

        is ChooseStudentScreenState.Result -> {

            MainContent(
                chooseNameState = chooseNameState,
                onApplyClickListener = onApplyClickListener,
                viewModel = viewModel,
                onBackPressClickListener= onBackPressClickListener,
                groups = viewModelState.groups
            )
        }
    }
    AppIcon()
}

@Composable
private fun LoadingContent() {
    ProgressIndicator()
}
@Composable
private fun MainContent(
    chooseNameState: MutableState<String>,
    onApplyClickListener: () -> Unit,
    viewModel: ChooseStudentViewModel,
    onBackPressClickListener: () -> Unit,
    groups: Groups
) {
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
            GradientMediumText(text = "Осталось только указать твою группу")
            SpacerHeight20dp()
            ExposedDropDownMenu(
                paddingValues = PaddingValues(12.dp),
                groups.groups
            ) {
                chooseNameState.value = it
            }
            SpacerHeight20dp()
            GradientButton(text = "\uD83D\uDCBCНачать") {
                if (chooseNameState.value == "") {

                } else {
                    onApplyClickListener()
                    viewModel.setupStudentProfile(
                        UserProfile.Student(chooseNameState.value)
                    )
                }

            }

            GradientButton(text = "Назад") {
                onBackPressClickListener()
            }
        }
    }
}