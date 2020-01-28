package com.example.appsflyerdebug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appsflyerdebug.service.AppsFlyerService
import com.example.appsflyerdebug.service.DeepLinkService
import com.example.appsflyerdebug.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as? MainApplication)?.deepLinkService = DeepLinkService(intent)

        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
