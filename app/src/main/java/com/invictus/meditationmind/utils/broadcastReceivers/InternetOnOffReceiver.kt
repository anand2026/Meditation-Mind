package com.invictus.meditationmind.utils.broadcastReceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.invictus.meditationmind.features.turnNetOnPage.utils.TurnNetOnPageUtils
import timber.log.Timber


class InternetOnOffReceiver : BroadcastReceiver() {

    companion object{
        var callback: (()->Unit)? = null
    }

    override fun onReceive(context: Context, intent: Intent) {
        Timber.d("isOnline==>>${TurnNetOnPageUtils.isOnline()}")
        callback?.invoke()
    }

}