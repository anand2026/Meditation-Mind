package com.invictus.meditationmind.data.sharedPrefs

import android.content.SharedPreferences
import androidx.annotation.Keep
import com.chibatching.kotpref.KotprefModel
import com.invictus.meditationmind.data.sharedPrefs.MeditationMindPrefKeyName.KOT_PREF_NAME

@Keep
object MeditationMindSharedPrefs : KotprefModel() {

    override val kotprefName: String = KOT_PREF_NAME

    fun registerOnSharedPreferenceChangeListener(listenerPrefValueChange: SharedPreferences.OnSharedPreferenceChangeListener?) {
        MeditationMindSharedPrefs.preferences.registerOnSharedPreferenceChangeListener(listenerPrefValueChange)
    }

    fun unregisterOnSharedPreferenceChangeListener(listenerPrefValueChange: SharedPreferences.OnSharedPreferenceChangeListener?) {
        listenerPrefValueChange?.let {
            MeditationMindSharedPrefs.preferences.unregisterOnSharedPreferenceChangeListener(listenerPrefValueChange)
        }
    }

    var FIREBASE_RECIPIENT_TOKEN: String by stringPref("", key = MeditationMindPrefKeyName.FIREBASE_RECIPIENT_TOKEN)
    var MOBILE_COMPANY_NAME: String by stringPref("", key = MeditationMindPrefKeyName.MOBILE_COMPANY_NAME)

    var PERIOD_LENGTH: Int by intPref(0, key = MeditationMindPrefKeyName.PERIOD_LENGTH)
    var CYCLE_LENGTH: Int by intPref(0, key = MeditationMindPrefKeyName.CYCLE_LENGTH)
    var IS_PERIOD_DETAIL_MANUAL_SET: Boolean by booleanPref(false, key = MeditationMindPrefKeyName.IS_PERIOD_DETAIL_MANUAL_SET)
    var IS_ONBOARDING_COMPLETE: Boolean by booleanPref(false, key = MeditationMindPrefKeyName.IS_ONBOARDING_COMPLETE)
    var PROFILE_PICTURE_URI: String by stringPref("", key = MeditationMindPrefKeyName.PROFILE_PICTURE_URI)
    var PROFILE_PICTURE_BACKGROUND_URI: String by stringPref("", key = MeditationMindPrefKeyName.PROFILE_PICTURE_BACKGROUND_URI)
    var IS_REVIEW_GIVEN: Boolean by booleanPref(false, key = MeditationMindPrefKeyName.IS_REVIEW_GIVEN)
    var PIN_LOCK_PASSWORD: String by stringPref("", key = MeditationMindPrefKeyName.PIN_LOCK_PASSWORD)
    var SUB_STATUS: Boolean by booleanPref(false, key = MeditationMindPrefKeyName.SUB_STATUS)

}
