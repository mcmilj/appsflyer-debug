package com.example.appsflyerdebug.service

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib

class AppsFlyerService(private val devKey: String,
                       private val application: Application) {

    companion object {
        private const val LOG_TAG = "AppsFlyerService"
    }

    private val appsFlyerLib get() = AppsFlyerLib.getInstance()

    init {
        val conversionDataListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                data?.let { cvData ->
                    cvData.map {
                        Log.i(LOG_TAG, "conversion_attribute:  ${it.key} = ${it.value}")
                    }
                }
            }

            override fun onConversionDataFail(error: String?) {
                Log.e(LOG_TAG, "error onAttributionFailure :  $error")
            }

            override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
                data?.map {
                    Log.d(LOG_TAG, "onAppOpen_attribute: ${it.key} = ${it.value}")
                }
            }

            override fun onAttributionFailure(error: String?) {
                Log.e(LOG_TAG, "error onAttributionFailure :  $error")
            }
        }

        appsFlyerLib.setDebugLog(true)
        appsFlyerLib.init(devKey, conversionDataListener, application)
    }

    fun initialise() {
        appsFlyerLib.trackAppLaunch(application, devKey)
        appsFlyerLib.startTracking(application)
    }
}
