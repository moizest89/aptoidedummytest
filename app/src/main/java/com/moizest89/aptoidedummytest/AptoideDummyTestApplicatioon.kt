package com.moizest89.aptoidedummytest

import android.app.Application
import com.moizest89.aptoidedummytest.di.getModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AptoideDummyTestApplicatioon : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AptoideDummyTestApplicatioon)
            modules(
                getModules()
            )
        }
    }
}
