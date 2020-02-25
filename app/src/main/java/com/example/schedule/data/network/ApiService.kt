package com.example.schedule.data.network

import com.example.schedule.data.model.Lesson
import io.reactivex.Single
import retrofit2.http.GET
//  https://sample.fitnesskit-admin.ru/schedule/get_group_lessons_v2/

interface ApiService {
    @GET("1/")
    fun getLessons(): Single<List<Lesson>>
}