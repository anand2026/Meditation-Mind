package com.invictus.meditationmind.core

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.chibatching.kotpref.Kotpref
import com.invictus.meditationmind.data.database.MeditationMindDatabase
import com.invictus.meditationmind.utils.CommonUtils.setDeviceCompanyNameInPref
import com.invictus.meditationmind.utils.firebaseDataUtils.FirebaseDataUtil
import timber.log.Timber


class MeditationMindApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initMVRXInstance()
        initRoomDBInstance()
        initTimber()
        initSharePreference()
        setDeviceCompanyNameInPref()
        initCrashlitics()
    }

    private fun initRoomDBInstance() {
        MeditationMindDatabase.getInstance()


    }

    private fun initSharePreference() {
        Kotpref.init(this)
    }

    private fun initTimber() {
        if (com.invictus.meditationmind.BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initMVRXInstance() {
        Mavericks.initialize(this)
    }


    private fun initCrashlitics() {
        FirebaseDataUtil.firebaseApp()
        FirebaseDataUtil.firebaseUser()?.uid?.let {
            FirebaseDataUtil.firebaseCrashlyticsInstance().setUserId(it)
        }
        FirebaseDataUtil.firebaseCrashlyticsInstance().setCrashlyticsCollectionEnabled(true)
    }

}