package com.invictus.meditationmind.features.mainActivityPage

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.invictus.meditationmind.features.mainActivityPage.component.MainActivityPageHome
import com.invictus.meditationmind.utils.broadcastReceivers.InternetOnOffReceiver
import com.invictus.meditationmind.utils.composeUtils.theme.ComposeMeditationMindTheme


class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private var mInternetOnOffReceiver: InternetOnOffReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInterNetReceiver()
//        GoogleBillingSdkOperation.registerBilling(this)
        setContent {
            ComposeMeditationMindTheme {
                MainActivityPageHome()
            }
        }
    }


    /**
     * ------------------------------Internet receiver----------------------
     */

    private fun initInterNetReceiver() {
        if (mInternetOnOffReceiver == null) {
            mInternetOnOffReceiver = InternetOnOffReceiver()
        }
    }

    override fun onStart() {
        super.onStart()
        runCatching {
            IntentFilter().apply {
                addAction(ConnectivityManager.CONNECTIVITY_ACTION)
            }.also {
                registerReceiver(mInternetOnOffReceiver, it)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        runCatching {
            if (mInternetOnOffReceiver != null) unregisterReceiver(mInternetOnOffReceiver)
        }
    }

}


//val LocalPlayerServiceBinder = staticCompositionLocalOf<PlayerService.Binder?> { null }
