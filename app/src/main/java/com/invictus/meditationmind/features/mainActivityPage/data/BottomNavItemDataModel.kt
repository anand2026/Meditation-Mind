package com.invictus.meditationmind.features.mainActivityPage.data

import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import com.invictus.meditationmind.R

@Keep
data class BottomNavItemDataModel(
    @DrawableRes val navIcon: Int = R.drawable.googleg_standard_color_18,
    val navIdentifier: BottomNavItemsIdentifiers = BottomNavItemsIdentifiers.HOME,
    val navName: String = "",
    val isVisible : Boolean = true
)
