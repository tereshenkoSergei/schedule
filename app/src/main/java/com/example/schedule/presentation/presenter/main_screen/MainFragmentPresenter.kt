package com.example.schedule.presentation.presenter.main_screen

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v4.content.ContextCompat.getSystemService
import android.support.v7.widget.LinearLayoutManager
import com.example.schedule.data.model.Lesson
import com.example.schedule.data.repository.IMainRepository
import com.example.schedule.data.repository.MainRepository
import com.example.schedule.presentation.ui.main_screen.RecyclerViewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragmentPresenter(
    private val view: IMainFragmentView
) {

    private var repository: IMainRepository = MainRepository.instance
    private lateinit var list: MutableList<Lesson>


    fun getLessons() {


        repository.getLessons()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                if (!it.isEmpty()) {

                    list = it.toMutableList()
                    view.showLessons(list)
                    view.saveLessons(list)
                }
            }, {
                println(it.localizedMessage)
            })

    }

    fun loadLessons() {
        view.showLessons(view.loadLessons())
    }

    fun saveLessons(items: MutableList<Lesson>) {
        view.saveLessons(items)
    }

}