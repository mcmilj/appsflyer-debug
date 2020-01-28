package com.example.appsflyerdebug.ui.main

import androidx.lifecycle.ViewModel
import com.example.appsflyerdebug.service.AppsFlyerService
import com.example.appsflyerdebug.service.DeepLinkService

class MainViewModel(private val appsFlyerService: AppsFlyerService,
                    deepLinkService: DeepLinkService) : ViewModel() {

    val actionText: CharSequence = "action = ${deepLinkService.action}"
    val schemeText: CharSequence = "scheme = ${deepLinkService.scheme}"
    val hostText: CharSequence = "host = ${deepLinkService.host}"
    val pathText: CharSequence = "path = ${deepLinkService.path}"

    fun optInClicked() {
        appsFlyerService.initialise()
    }
}
