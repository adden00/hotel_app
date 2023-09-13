package com.adden00.testtaskeffectivemobile.app

import android.app.Application
import com.adden00.testtaskeffectivemobile.app.di.AppComponentProvider
import com.adden00.testtaskeffectivemobile.app.di.SubComponents

class MainApp : Application(), SubComponents {
    override fun onCreate() {
        super.onCreate()
        AppComponentProvider.buildDi(this)
    }
}

