package com.invictus.meditationmind.features.setting.data

import androidx.annotation.Keep

@Keep
data class SettingItems(
    val icon:Int,
    val title:String,
    val identifier:SettingIdentifier
)
