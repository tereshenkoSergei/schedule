package com.example.schedule.data.repository

import com.example.schedule.data.model.Lesson
import io.reactivex.Single

interface IMainRepository {
    fun getLessons():Single<List<Lesson>>
}