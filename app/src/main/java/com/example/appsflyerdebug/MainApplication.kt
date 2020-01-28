package com.example.appsflyerdebug

import android.app.Application
import com.example.appsflyerdebug.service.AppsFlyerService
import com.example.appsflyerdebug.service.DeepLinkService

class MainApplication: Application() {

    lateinit var deepLinkService: DeepLinkService
    lateinit var appsFlyerService: AppsFlyerService

    val viewModelFactory = ViewModelFactory(this)

    override fun onCreate() {
        super.onCreate()
        appsFlyerService = AppsFlyerService("devKey", this)
    }
}