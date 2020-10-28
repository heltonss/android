package com.heltonsilveira.modularizacao

import android.app.Application
import com.heltonsilveira.data.di.dataModules
import com.heltonsilveira.domain.di.domainModule
import com.heltonsilveira.modularizacao.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(domainModule + dataModules + listOf(presentationModule))
        }
    }
}