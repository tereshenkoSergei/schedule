package com.example.schedule.presentation.ui.main_screen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.schedule.R
import com.example.schedule.data.cicerone.CiceroneNavigation
import com.example.schedule.data.model.Lesson
import com.example.schedule.data.model.Screens
import kotlinx.android.synthetic.main.item_lesson.view.*

class RecyclerViewAdapter(
    private var items: MutableList<Lesson>

) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHoler>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHoler {
        return ViewHoler(LayoutInflater.from(p0.context).inflate(R.layout.item_lesson, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: ViewHoler, position: Int) {
        viewHolder.itemView.lesson_name_text_view.text = items[position].name
        viewHolder.itemView.start_time_test_view.text = items[position].startTime
        viewHolder.itemView.end_time_test_view.text = items[position].endTime
        viewHolder.itemView.teacher_text_view.text = items[position].teacher
        viewHolder.itemView.position_text_view.text = position.toString()

    }




    inner class ViewHoler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                CiceroneNavigation.INSTANCE.getRouter().navigateTo(
                    Screens.LESSON_DESCRIPTION_FRAGMENT,
                    //getting lesson
                    items[it.position_text_view.text.toString().toBigInteger().toInt()]
                )
            }

        }

    }

    fun getItems():MutableList<Lesson>{
        return items.toMutableList()
    }

}