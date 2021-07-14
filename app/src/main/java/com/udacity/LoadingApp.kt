package com.udacity

import android.app.Application
import timber.log.Timber

/**
 * Created by heinhtet deevvdd@gmail.com on 12,July,2021
 */
class LoadingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}