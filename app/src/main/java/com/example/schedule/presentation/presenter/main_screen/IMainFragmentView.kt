package com.example.schedule.presentation.presenter.main_screen

import com.example.schedule.data.model.Lesson

interface IMainFragmentView {
    fun showLessons(items:MutableList<Lesson>)
    fun saveLessons(items: MutableList<Lesson>)
    fun loadLessons():MutableList<Lesson>
}