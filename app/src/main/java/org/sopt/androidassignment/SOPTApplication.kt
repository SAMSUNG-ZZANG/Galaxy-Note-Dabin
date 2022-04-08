package org.sopt.androidassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.sopt.core.util.SOPTDebugTree
import timber.log.Timber

@HiltAndroidApp
class SOPTApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(SOPTDebugTree())
        }
    }
}
