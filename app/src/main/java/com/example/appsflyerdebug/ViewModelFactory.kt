package com.example.appsflyerdebug

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appsflyerdebug.ui.main.MainViewModel

class ViewModelFactory(private val application: MainApplication): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MainViewModel::class.java -> MainViewModel(application.appsFlyerService, application.deepLinkService)
            else -> throw IllegalArgumentException()
        } as T
    }
}