package com.example.timetableapp.domain.reaction

import java.lang.Exception


sealed class Reaction<out T> {
    data class Error(val exception: Exception): Reaction<Nothing>()
    data class Success<out T>(val data: T) : Reaction<T>()
}
