package com.example.schedule.presentation.ui.description

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.schedule.R
import com.example.schedule.data.model.Lesson
import com.example.schedule.presentation.presenter.description.DescriptionLessonFragmentPresenter
import com.example.schedule.presentation.presenter.description.IDescriptionLessonFragmentView
import kotlinx.android.synthetic.main.fragment_lesson_description.*
import kotlinx.android.synthetic.main.toolbar.*


class DescriptionLessonFragment : Fragment(), IDescriptionLessonFragmentView {

    private lateinit var lesson: Lesson
    private lateinit var presenter: DescriptionLessonFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lesson_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        presenter = DescriptionLessonFragmentPresenter(this)
        presenter.showLessonDescribtion()

    }


    fun putData(lesson: Lesson): DescriptionLessonFragment {
        this.lesson = lesson
        return this
    }

    override fun showLessonDescribtion() {
        description_text_view.text = lesson.description
        lesson_text_view.text = lesson.name
        place_text_view.text = lesson.place
        time_text_view.text = lesson.startTime + " - " + lesson.endTime
        teacher_text_description_view.text = lesson.teacher
        room_description_text_view.text = lesson.place
    }

}