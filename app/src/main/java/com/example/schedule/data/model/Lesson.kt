package com.example.schedule.data.model

import java.io.Serializable

class Lesson(
    val name: String?,
    val startTime: String?,
    val endTime: String?,
    val teacher: String?,
    val place: String?,
    val description: String?,
    val weekDay: Int?
) : Serializable {

    fun getStringWeekDay(): String = when (weekDay) {
        1 -> "Понедельник"
        2 -> "Вторник"
        3 -> "Среда"
        4 -> "Четверг"
        5 -> "Пятница"
        6 -> "Суббота"
        7 -> "Воскресенье"
        else -> throw Exception()


    }
}