package com.example.schedule.data.repository

import com.example.schedule.data.model.Lesson
import com.example.schedule.data.network.ApiClient
import io.reactivex.Single

class MainRepository : IMainRepository {
    override fun getLessons(): Single<List<Lesson>> {
        return service.getLessons()
    }

        private object Holder {
            val instance = MainRepository()
        }

        companion object {
            val instance: MainRepository by lazy { Holder.instance }
        }


        private val service = ApiClient.instance.apiService

    }
