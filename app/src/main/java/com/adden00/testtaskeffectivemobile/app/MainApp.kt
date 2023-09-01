package com.adden00.testtaskeffectivemobile.app

import android.app.Application
import android.content.Context
import com.adden00.testtaskeffectivemobile.app.di.AppComponent
import com.adden00.testtaskeffectivemobile.app.di.DaggerAppComponent

class MainApp : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}

fun Context.getAppComponent(): AppComponent = (this.applicationContext as MainApp).appComponent