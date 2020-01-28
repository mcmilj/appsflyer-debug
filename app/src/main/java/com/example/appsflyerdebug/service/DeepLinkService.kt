package com.example.appsflyerdebug.service

import android.content.Intent

class DeepLinkService(intent: Intent) {
    val action = intent.action
    val scheme = intent.data?.scheme
    val host = intent.data?.host
    val path = intent.data?.path
}