package com.invictus.meditationmind.features.mainActivityPage.component

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksActivityViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.filterCategory.component.MostPopularHome
import com.invictus.meditationmind.features.homePage.component.HomePage
import com.invictus.meditationmind.features.homePage.utils.HomePageUtils
import com.invictus.meditationmind.features.homePage.utils.HomePageUtils.notificationPermissionIntent
import com.invictus.meditationmind.features.listening.ListeningPage
import com.invictus.meditationmind.features.mainActivityPage.MainActivityPageState
import com.invictus.meditationmind.features.mainActivityPage.MainActivityPageViewModel
import com.invictus.meditationmind.features.mainActivityPage.Routes
import com.invictus.meditationmind.features.onBoardingFlow.component.WelcomePage
import com.invictus.meditationmind.features.setting.component.SettingPage
import com.invictus.meditationmind.utils.composeUtils.commonUi.MeditationMindLoadingView
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import splitties.toast.toast
import timber.log.Timber


@Composable
fun MainActivityPageHome() {

    val context = LocalContext.current

    val mainActivityPageViewModel: MainActivityPageViewModel = mavericksActivityViewModel()
    val isDeviceInternetOn by mainActivityPageViewModel.collectAsState(MainActivityPageState::isDeviceInternetOn)
    val globalNavItem by mainActivityPageViewModel.collectAsState(MainActivityPageState::globalNavItem)

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = MaterialTheme.colors.appBackgroundColor
    )


    val isNeedToShowAutoTimePage = remember { mutableStateOf(true) }


    val launcherNotificationPermission = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {
        val message = if (!HomePageUtils.isNotificationPermissionGiven()) {
            context.getString(R.string.something_wrong_try_again)
        } else {
            context.getString(R.string.success)
        }
        toast(message)
    }

    val navController = rememberNavController()

    LaunchedEffect(key1 = Unit) {
        try {
            if (!HomePageUtils.isNotificationPermissionGiven()) {
                launcherNotificationPermission.launch(notificationPermissionIntent())
            }
        } catch (e: Exception) {
            Timber.d("==>AgreeTermsPage_70 $e")
        }
    }

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {

//        if (AutoDateTimePageUtil.isAutoTimeOff() && isNeedToShowAutoTimePage.value || !isDeviceInternetOn) {
////        if (false) {
//            Crossfade(
//                targetState = AutoDateTimePageUtil.isAutoTimeOff() && isNeedToShowAutoTimePage.value,label = ""
//            ) {
//                if (it) AutoDateTimePageHome { isNeedToShowAutoTimePage.value = false }
//            }
//
//            Crossfade(targetState = !isDeviceInternetOn, label = "") {
//                if (it) TurnNetOnPageHome()
//            }
//        } else {

            NavHost(navController = navController, startDestination = Routes.WelcomePage.route) {
                composable(Routes.WelcomePage.route){
                    WelcomePage(navController)
                }
                composable(Routes.Home.route) {
                    HomePage(navController)
                }
                composable(Routes.Listening.route,
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) { arg ->
                    val id = arg.arguments?.getString("id")
                    ListeningPage(navController, id )
                }
                composable(Routes.MostPopular.route,) {
                    MostPopularHome(navController)
                }
                composable(Routes.SettingPage.route,) {
                    SettingPage(navController)
                }
            }


//            MainActivityLandingPage(mainActivityPageViewModel)

//        }


        MeditationMindLoadingView(context = context, isVisible = false, backgroundColor = colorResource(id = R.color.overlay_dark_40))
    }
}
