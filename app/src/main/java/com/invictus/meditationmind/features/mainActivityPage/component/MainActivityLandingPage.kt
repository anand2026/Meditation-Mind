package com.invictus.meditationmind.features.mainActivityPage.component

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.mvrx.compose.collectAsState
import com.invictus.meditationmind.features.graphCalendar.component.CalendarPageHome
import com.invictus.meditationmind.features.mainActivityPage.MainActivityPageState
import com.invictus.meditationmind.features.mainActivityPage.MainActivityPageViewModel
import com.invictus.meditationmind.features.mainActivityPage.data.BottomNavItemsIdentifiers
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor

@Composable
fun MainActivityLandingPage(viewModel: MainActivityPageViewModel) {

    val selectedNavItem by viewModel.collectAsState(MainActivityPageState::selectedNavItem)

    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
        ) { pad ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pad)
            ) {

//                Crossfade(
//                    targetState = selectedNavItem == BottomNavItemsIdentifiers.HOME,  label = ""
//                ) {
//                    if(it)HomePage(navController)
//                }
//                Crossfade(
//                    targetState = selectedNavItem == BottomNavItemsIdentifiers.PROFILE,  label = ""
//                ) {
//                    if(it)ListeningPage(navController)
//                }
                Crossfade(
                    targetState = selectedNavItem == BottomNavItemsIdentifiers.CALENDAR, label = ""
                ) {
                    if(it)CalendarPageHome()
                }

            }
        }
    }
}