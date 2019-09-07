package com.dsp.kindness

import android.app.Application
import com.dsp.kindness.di.actModule
import com.dsp.kindness.di.appModule
import org.koin.android.ext.android.startKoin

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin(
            this, listOf(
                appModule,
                actModule
            )
        )
    }
}
