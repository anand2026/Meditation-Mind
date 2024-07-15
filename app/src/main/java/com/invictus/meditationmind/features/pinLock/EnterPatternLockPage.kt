package com.invictus.meditationmind.features.pinLock

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.invictus.meditationmind.R
import com.invictus.meditationmind.data.sharedPrefs.MeditationMindSharedPrefs
import com.invictus.meditationmind.features.mainActivityPage.MainActivityPageViewModel
import com.invictus.meditationmind.features.mainActivityPage.data.BottomNavItemsIdentifiers

@Composable
fun EnterPatternLockPage(mainActivityPageViewModel: MainActivityPageViewModel) {

    val passwordWritten = remember { mutableStateOf("") }
    PinLockView(
        stringResource(if (passwordWritten.value.isEmpty()) R.string.enter_pin_to_lock else R.string.re_enter_pin_to_lock),
        passwordWritten.value,
        true,
        reEnterCallback = { passwordWritten.value = it },
        closeCallback = { mainActivityPageViewModel.setSelectedGlobalNavItem(BottomNavItemsIdentifiers.NONE) }
    ) {
        MeditationMindSharedPrefs.PIN_LOCK_PASSWORD = passwordWritten.value
        mainActivityPageViewModel.setSelectedGlobalNavItem(BottomNavItemsIdentifiers.NONE)
    }

}