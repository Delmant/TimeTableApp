package com.example.timetableapp.app

import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val input = java.util.Scanner(System.`in`)

    // Ввод количества массивов
    println("Введите количество массивов (не более 3): ")
    val numberOfArrays = input.nextInt()

    if (numberOfArrays > 3) {
        println("Количество массивов не может быть больше 3.")
        return
    }

    // Инициализация массивов
    val arrays = mutableListOf<Array<IntArray>>()

    for (i in 1..numberOfArrays) {
        println("Введите размерность массива $i (строки и столбцы через пробел): ")
        val rows = input.nextInt()
        val cols = input.nextInt()

        val array = Array(rows) { IntArray(cols) }

        println("Введите элементы массива $i:")
        for (j in 0 until rows) {
            for (k in 0 until cols) {
                array[j][k] = input.nextInt()
            }
        }

        arrays.add(array)
    }

    // Формирование одномерного массива
    val resultArray = mutableListOf<Int>()

    for (array in arrays) {
        for (i in 0 until array.size) {
            if (array[i][0] > 0) {
                resultArray.add(array[i][0])
            }
        }
    }

    // Вывод одномерного массива
    println("Одномерный массив с положительными элементами первых строк:")
    resultArray.forEach { print("$it ") }

    // Статистика
    val positiveElementsCount = resultArray.size
    val nonPositiveElementsCount = numberOfArrays * arrays[0].size - positiveElementsCount

    // Вывод статистики
    println("\nКоличество переписанных элементов: $positiveElementsCount")
    println("Количество элементов, не соответствующих условию для переписывания: $nonPositiveElementsCount")
}
