package com.example.schedule.presentation.ui.main_screen

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.getSystemService
import android.widget.Toast
import com.example.schedule.R
import com.example.schedule.data.cicerone.CiceroneNavigation
import com.example.schedule.data.model.Lesson
import com.example.schedule.data.model.Screens
import com.example.schedule.presentation.ui.description.DescriptionLessonFragment
import kotlinx.android.synthetic.main.toolbar.*
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import java.io.File
import java.nio.file.Paths

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)






        CiceroneNavigation.INSTANCE.getNavigationHolder().setNavigator(navigator)
        CiceroneNavigation.INSTANCE.getRouter().navigateTo(Screens.MAIN_SCREEN)


    }


    private val navigator = object : SupportFragmentNavigator(
        supportFragmentManager,
        R.id.container
    ) {
        override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
            Screens.MAIN_SCREEN -> MainScreenFragment()
            Screens.LESSON_DESCRIPTION_FRAGMENT -> {
                DescriptionLessonFragment().putData((data as Lesson))
            }
            else -> throw Exception()

        }

        override fun exit() {
            finish()
        }

        override fun showSystemMessage(message: String?) {
            Toast.makeText(this@MainActivity, "System message", Toast.LENGTH_SHORT).show()
        }

    }


}
