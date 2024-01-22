package com.example.timetableapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.timetableapp.presentation.screens.navigation_handler.NavigationHandler
import com.example.timetableapp.ui.theme.TimeTableAppTheme
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            TimeTableAppTheme {
                NavigationHandler()
            }
        }


    }
}


