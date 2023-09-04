package com.adden00.testtaskeffectivemobile.app

import android.app.Application
import com.adden00.testtaskeffectivemobile.app.di.AppComponentProvider
import com.adden00.testtaskeffectivemobile.app.di.SubComponents

class MainApp : Application(), SubComponents {
    //    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        AppComponentProvider.buildDi(this)
//        appComponent = DaggerAppComponent.factory().create(this)
    }
}

//fun Context.getAppComponent(): AppComponent = (this.applicationContext as MainApp).appComponent
