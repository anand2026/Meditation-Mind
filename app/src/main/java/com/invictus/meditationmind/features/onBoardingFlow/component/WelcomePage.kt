package com.invictus.meditationmind.features.onBoardingFlow.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.mainActivityPage.Routes
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import kotlinx.coroutines.delay

@Composable
fun WelcomePage(navController: NavHostController) {

    LaunchedEffect(key1 = Unit) {
        delay(1000)
//        mainActivityPageViewModel.setSelectedGlobalNavItem(
//            when{
//                !MeditationMindSharedPrefs.IS_ONBOARDING_COMPLETE -> BottomNavItemsIdentifiers.ONBOARDING_QUESTION1
////                !MeditationMindSharedPrefs.SUB_STATUS -> BottomNavItemsIdentifiers.PREMIUM_POPUP
//                else-> {BottomNavItemsIdentifiers.NONE}
//            }
//        )
        navController.navigate(Routes.Home.route)
    }

    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.splash_screen_elements),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
            )

        }
    }

}
