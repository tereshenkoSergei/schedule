package com.example.schedule.presentation.ui.main_screen

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.getSystemService
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.schedule.R
import com.example.schedule.data.model.Lesson
import com.example.schedule.presentation.presenter.main_screen.IMainFragmentView
import com.example.schedule.presentation.presenter.main_screen.MainFragmentPresenter
import kotlinx.android.synthetic.main.fragment_main.*
import java.io.File
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import android.support.v4.content.ContextCompat.getSystemService
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*


class MainScreenFragment : Fragment(), IMainFragmentView {
    //  private val PATH = "lessons.txt"
    // val file = File(PATH)
    lateinit var PATH: String
    lateinit var file: File
    lateinit var adapter: RecyclerViewAdapter
    lateinit var presenter: MainFragmentPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
           activity?.finish()
        }


        PATH = context?.filesDir?.path.toString() + "/lessons.txt"
        file = File(PATH)
        file.setWritable(true)
        if (!file.exists()) {
            file.createNewFile()
        }

        presenter = MainFragmentPresenter(this)
        presenter.loadLessons()
        presenter.getLessons()


       // presenter.saveLessons(adapter.getItems())
    }


    override fun showLessons(items: MutableList<Lesson>) {
        adapter = RecyclerViewAdapter(items)
        lessons_recycler_view.adapter = adapter
        lessons_recycler_view.layoutManager = LinearLayoutManager(context)
    }

    override fun loadLessons(): MutableList<Lesson> {

        var result = ArrayList<Lesson>().toMutableList()



        if (file.length().compareTo(0)!=0) {

            val inputStream = ObjectInputStream(file.inputStream())

            result =(inputStream.readObject() as ArrayList<Lesson>)
                .toMutableList()  }


        return result
    }
    override fun saveLessons(items: MutableList<Lesson>) {



        val outputStream = ObjectOutputStream(file.outputStream())

        val item = ArrayList<Lesson>()
        item.addAll(items)



        outputStream.writeObject(item)
    }

    fun onl(){



    }
    fun isOnline(): Boolean {
        val connMgr = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo
        var connected = networkInfo != null && networkInfo!!.isAvailable && networkInfo!!.isConnected
        return connected
    }

    /* outputStream.writeObject(
         Bundle().putSerializable("list_of_lessons", ArrayList<Lesson>().addAll(items))
     )*/
}