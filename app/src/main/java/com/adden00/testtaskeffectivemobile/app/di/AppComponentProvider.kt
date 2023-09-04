package com.adden00.testtaskeffectivemobile.app.di

import com.adden00.testtaskeffectivemobile.app.MainApp

object AppComponentProvider {
    private lateinit var appComponent: AppComponent

    @JvmStatic
    fun appComponent() = appComponent

    fun buildDi(application: MainApp) {
        appComponent = DaggerAppComponent.factory().create(application)
    }
}