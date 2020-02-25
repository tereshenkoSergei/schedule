package com.example.schedule.data.cicerone

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class CiceroneNavigation {
    companion object{
        var INSTANCE : CiceroneNavigation = CiceroneNavigation()
        private var cicerone:Cicerone<Router>? = Cicerone.create()
    }

    fun getNavigationHolder():NavigatorHolder{
        return  cicerone!!.navigatorHolder
    }
    fun getRouter():Router{
        return cicerone!!.router
    }
}